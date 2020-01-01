package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.common.error.MicroError;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.transport.DialOption;

/**
 * Pool is an interface for connection pooling
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Pool {

    // close the pool
    void close() throws MicroRpcException;

    // get a connection
    Conn get(String addr, DialOption... opts) throws MicroRpcException;

    // release the connection
    void release(Conn c, MicroError status) throws MicroRpcException;
}
