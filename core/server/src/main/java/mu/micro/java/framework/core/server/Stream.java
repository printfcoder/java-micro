package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.common.error.MicroError;
import mu.micro.java.framework.core.context.MicroContext;

public interface Stream {
    MicroContext getContext();

    Request getRequest();

    // todo Exception
    void Send(Object o) throws Exception;

    // todo Exception
    void Recv(Object o) throws Exception;

    MicroError getError();

    // todo Exception
    void Close() throws Exception;
}
