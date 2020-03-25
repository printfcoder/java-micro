package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.broker.PublishOption;
import mu.micro.java.framework.core.common.exception.QingniaoRpcException;
import mu.micro.java.framework.core.context.QingniaoContext;


public interface Client {
    void init(Option... options) throws QingniaoRpcException;

    Options options();

    Message newMessage(String topic, Object msg, MessageOption... opts);

    Request newRequest(String service, String endpoint, Object req, RequestOption... reqOpts);

    void call(QingniaoContext ctx, Request request, Object rsp, CallOption... opts) throws QingniaoRpcException;

    Stream stream(QingniaoContext ctx, Request request, CallOption... opts) throws QingniaoRpcException;

    void publish(QingniaoContext ctx, Message message, PublishOption... opts) throws QingniaoRpcException;
}
