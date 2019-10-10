package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.transport.Client;

import java.util.Date;

import lombok.AllArgsConstructor;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@AllArgsConstructor
public class DefaultPoolConn implements Conn {

    private Client client;
    private String id;
    private Date created;


    @Override
    public String id() {
        return this.id;
    }

    @Override
    public Date created() {
        return this.created;
    }

    @Override
    public Client client() {
        return this.client;
    }
}
