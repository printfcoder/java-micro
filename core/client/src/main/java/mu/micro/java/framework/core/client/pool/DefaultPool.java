package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.common.error.MicroError;
import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.transport.Client;
import mu.micro.java.framework.core.transport.DialOption;
import mu.micro.java.framework.core.transport.Transport;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;


public class DefaultPool implements Pool {

    ReentrantLock lock = new ReentrantLock();

    private int size;
    private Duration ttl;
    private Transport tr;
    private Map<String, List<DefaultPoolConn>> conns;

    public DefaultPool(int size, Duration ttl, Transport tr, Map<String, List<DefaultPoolConn>> conns) {
        this.size = size;
        this.ttl = ttl;
        this.tr = tr;
        this.conns = conns;
    }

    @Override
    public synchronized void close() throws MicroException {
        conns.entrySet().removeIf(e -> {
            conns.get(e).forEach(conn -> conn.client().close());
            return true;
        });
    }

    @Override
    public Conn get(String addr, DialOption... opts) throws MicroException {
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
    public void release(Conn c, MicroError status) throws MicroException {
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
