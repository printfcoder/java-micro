package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.common.error.QingniaoError;
import mu.micro.java.framework.core.common.exception.QingniaoRpcException;
import mu.micro.java.framework.core.transport.DialOption;

public interface Pool {

    // close the pool
    void close() throws QingniaoRpcException;

    // get a connection
    Conn get(String addr, DialOption... opts) throws QingniaoRpcException;

    // release the connection
    void release(Conn c, QingniaoError status) throws QingniaoRpcException;
}
