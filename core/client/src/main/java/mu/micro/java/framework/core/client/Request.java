package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.codec.Writer;


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
