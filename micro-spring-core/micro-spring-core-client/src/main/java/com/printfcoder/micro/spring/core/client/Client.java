package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Client {
    void init(Option... options) throws MicroRpcException;

    Options options();

    Message newMessage(String topic, Object msg, MessageOption... opts);


}
