package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.common.error.MicroError;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * Stream is the interface for a bidirectional synchronous stream
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Stream {
    // Context for the stream
    MicroContext context();

    // The request made
    Request request();

    // The response read
    Response response();

    // send will encode and send a request
    void send(Object o) throws MicroRpcException;

    // recv will decode and read a response
    void recv(Object o) throws MicroRpcException;

    // error returns the stream error
    MicroError error();

    // close closes the stream
    void close() throws MicroRpcException;
}
