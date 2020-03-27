package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.context.MicroContext;

public interface Router {
    // todo Exception
    void processMessage(MicroContext context, Message msg) throws Exception;
    void serveRequest(MicroContext context,Request req, Response) throws Exception;
}
