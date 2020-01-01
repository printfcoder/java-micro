package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.broker.PublishOption;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Client {
    void init(Option... options) throws MicroRpcException;

    Options options();

    Message newMessage(String topic, Object msg, MessageOption... opts);

    Request newRequest(String service, String endpoint, Object req, RequestOption... reqOpts);

    void call(MicroContext ctx, Request request, Object rsp, CallOption... opts) throws MicroRpcException;

    Stream stream(MicroContext ctx, Request request, CallOption... opts) throws MicroRpcException;

    void publish(MicroContext ctx, Message message, PublishOption... opts) throws MicroRpcException;
}
