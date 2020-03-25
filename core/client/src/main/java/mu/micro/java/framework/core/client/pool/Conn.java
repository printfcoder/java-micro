package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.transport.Client;

import java.util.Date;


public interface Conn {

    Client client();

    // unique id of connection
    String id();

    // time it was created
    Date created();
}
