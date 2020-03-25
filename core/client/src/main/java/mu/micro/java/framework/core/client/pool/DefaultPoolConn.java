package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.transport.Client;

import java.util.Date;

import lombok.AllArgsConstructor;


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
