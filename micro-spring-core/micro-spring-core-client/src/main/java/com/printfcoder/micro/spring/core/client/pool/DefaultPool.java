package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.common.error.MicroError;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.transport.Client;
import com.printfcoder.micro.spring.core.transport.DialOption;
import com.printfcoder.micro.spring.core.transport.Transport;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

import lombok.AllArgsConstructor;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@AllArgsConstructor
public class DefaultPool implements Pool {

    ReentrantLock lock = new ReentrantLock();

    private int size;
    private Duration ttl;
    private Transport tr;
    private Map<String, List<DefaultPoolConn>> conns;


    @Override
    public synchronized void close() throws MicroRpcException {
        conns.entrySet().removeIf(e -> {
            conns.get(e).forEach(conn -> conn.client().close());
            return true;
        });
    }

    @Override
    public Conn get(String addr, DialOption... opts) throws MicroRpcException {
        lock.lock();
        List<DefaultPoolConn> pools = this.conns.get(addr);

        // while we have conns check age and then return one
        // otherwise we'll create a new conn
        while (pools.size() > 0) {
            DefaultPoolConn lastOneConn = pools.get(pools.size());
            pools = pools.subList(0, pools.size() - 1);

            // if conn is old kill it and move on
            if ((new Date().getTime() - lastOneConn.created().getTime()) * 1000 > this.ttl.getSeconds()) {
                lastOneConn.client().close();
                continue;
            }

            lock.unlock();

            return lastOneConn;
        }

        lock.unlock();

        // create new conn
        Client client = this.tr.dial(addr, opts);

        return new DefaultPoolConn(client, UUID.randomUUID().toString(), new Date());
    }

    @Override
    public void release(Conn c, MicroError status) throws MicroRpcException {
        // don't store the conn if it has errored
        if (status != null) {
            c.client().close();
            return;
        }

        // otherwise put it back for reuse
        lock.lock();

        List<DefaultPoolConn> conns = this.conns.get(c.client().remote());
        if (conns != null && conns.size() > this.size) {
            lock.lock();
            c.client().close();
            return;
        }

        this.conns.get(c.client().remote()).add((DefaultPoolConn) c);
        lock.unlock();
    }
}
