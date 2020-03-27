package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.registry.Endpoint;

import java.util.List;

public interface Handler {
    String getName();
    // todo object
    Object getHandler();
    List<Endpoint> getEndpoints();
    HandlerOptions getOptions();
}
