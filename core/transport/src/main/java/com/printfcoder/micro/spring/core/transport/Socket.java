package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
public interface Socket {
    void recv(Message message) throws MicroRpcException;

    void send(Message message) throws MicroRpcException;

    void close() throws MicroRpcException;

    String local();

    String remote();
}
