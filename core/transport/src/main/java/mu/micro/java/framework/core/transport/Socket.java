package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.common.exception.MicroException;


public interface Socket {
    void recv(Message message) throws MicroException;

    void send(Message message) throws MicroException;

    void close() throws MicroException;

    String local();

    String remote();
}
