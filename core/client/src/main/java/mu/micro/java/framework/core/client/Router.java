package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.context.MicroContext;
import sun.misc.Request;

import javax.xml.ws.Response;


public interface Router {
    Response sendRequest(MicroContext context, Request request) throws MicroException;
}
