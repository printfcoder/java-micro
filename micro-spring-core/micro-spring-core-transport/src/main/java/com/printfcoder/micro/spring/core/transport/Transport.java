package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public interface Transport {
    void init(Option... opts) throws MicroRpcException;

    Options options();

    Client dial(String addr, DialOption... opts) throws MicroRpcException;

    Listener listen(String addr, ListenOption... opts) throws MicroRpcException;

    String string();
}
