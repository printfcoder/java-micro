package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.registry.Endpoint;

import java.util.List;

public interface Subscriber {
    String getTopic();
    // todo Object
    Object getSubscriber();
    List<Endpoint> getEndpoints();
    SubscriberOptions getOptions();
}
