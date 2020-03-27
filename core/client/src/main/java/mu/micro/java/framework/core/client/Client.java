package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.broker.PublishOption;
import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.context.MicroContext;


public interface Client {
    void init(Option... options) throws MicroException;

    Options options();

    Message newMessage(String topic, Object msg, MessageOption... opts);

    Request newRequest(String service, String endpoint, Object req, RequestOption... reqOpts);

    void call(MicroContext ctx, Request request, Object rsp, CallOption... opts) throws MicroException;

    Stream stream(MicroContext ctx, Request request, CallOption... opts) throws MicroException;

    void publish(MicroContext ctx, Message message, PublishOption... opts) throws MicroException;
}
