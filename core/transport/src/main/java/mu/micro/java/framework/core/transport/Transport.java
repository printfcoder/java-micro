package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.common.exception.QingniaoRpcException;


public interface Transport {
    void init(Option... opts) throws QingniaoRpcException;

    Options options();

    Client dial(String addr, DialOption... opts) throws QingniaoRpcException;

    Listener listen(String addr, ListenOption... opts) throws QingniaoRpcException;

    String string();
}
