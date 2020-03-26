package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.common.exception.QingniaoRpcException;


public interface Socket {
    void recv(Message message) throws QingniaoRpcException;

    void send(Message message) throws QingniaoRpcException;

    void close() throws QingniaoRpcException;

    String local();

    String remote();
}
