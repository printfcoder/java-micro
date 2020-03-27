package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.common.error.MicroError;
import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.transport.DialOption;

public interface Pool {

    // close the pool
    void close() throws MicroException;

    // get a connection
    Conn get(String addr, DialOption... opts) throws MicroException;

    // release the connection
    void release(Conn c, MicroError status) throws MicroException;
}
