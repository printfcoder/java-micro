package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.spring.core.codec.Writer;

/**
 * Request is the interface for a synchronous request used by Call or Stream
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Request {
    // The service to call
    String service();

    // The action to take
    String method();

    // The endpoint to invoke
    String endpoint();

    // The content type
    String contentType();

    // The unencoded request body
    Object body();

    // Write to the encoded request writer. This is nil before a call is made
    Writer codec();

    // indicates whether the request will be a streaming one rather than unary
    boolean stream();
}
