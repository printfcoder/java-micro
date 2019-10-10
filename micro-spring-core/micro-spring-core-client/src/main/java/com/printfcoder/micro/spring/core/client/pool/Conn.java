package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.transport.Client;

import java.util.Date;

/**
 * Pool is an interface for connection pooling
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Conn {

    Client client();

    // unique id of connection
    String id();

    // time it was created
    Date created();
}
