package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.common.error.MicroError;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.transport.DialOption;
import com.printfcoder.micro.spring.core.transport.Transport;
import java.time.Duration;
import java.util.List;
import java.util.Map;
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

        return null;
    }

    @Override
    public void release(Conn c, MicroError status) throws MicroRpcException {

    }
}
