package com.printfcoder.micro.spring.core.impl.client.rpc;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.broker.PublishOption;
import com.printfcoder.micro.spring.core.client.*;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public class RpcClient implements Client {
    @Override
    public void init(Option... options) throws MicroRpcException {

    }

    @Override
    public Options options() {
        return null;
    }

    @Override
    public Message newMessage(String topic, Object msg, MessageOption... opts) {
        return null;
    }

    @Override
    public Request newRequest(String service, String endpoint, Object req, RequestOption... reqOpts) {
        return null;
    }

    @Override
    public void call(MicroContext ctx, Request request, Object rsp, CallOption... opts) throws MicroRpcException {

    }

    @Override
    public Stream stream(MicroContext ctx, Request request, CallOption... opts) throws MicroRpcException {
        return null;
    }

    @Override
    public void publish(MicroContext ctx, Message message, PublishOption... opts) throws MicroRpcException {

    }
}
