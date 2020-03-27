package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.error.MicroError;
import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.context.MicroContext;


public interface Stream {
    // Context for the stream
    MicroContext context();

    // The request made
    Request request();

    // The response read
    Response response();

    // send will encode and send a request
    void send(Object o) throws MicroException;

    // recv will decode and read a response
    void recv(Object o) throws MicroException;

    // error returns the stream error
    MicroError error();

    // close closes the stream
    void close() throws MicroException;
}
