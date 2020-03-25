package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.error.QingniaoError;
import mu.micro.java.framework.core.common.exception.QingniaoRpcException;
import mu.micro.java.framework.core.context.QingniaoContext;


public interface Stream {
    // Context for the stream
    QingniaoContext context();

    // The request made
    Request request();

    // The response read
    Response response();

    // send will encode and send a request
    void send(Object o) throws QingniaoRpcException;

    // recv will decode and read a response
    void recv(Object o) throws QingniaoRpcException;

    // error returns the stream error
    QingniaoError error();

    // close closes the stream
    void close() throws QingniaoRpcException;
}
