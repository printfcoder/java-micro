package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.common.exception.QingniaoRpcException;
import mu.micro.java.framework.core.common.struct.Func;


public interface Listener {
    String addr();

    void close();

    void accept(Func<Socket> func) throws QingniaoRpcException;
}
