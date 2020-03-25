package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.exception.QingniaoRpcException;
import mu.micro.java.framework.core.context.QingniaoContext;
import sun.misc.Request;

import javax.xml.ws.Response;


public interface Router {
    Response sendRequest(QingniaoContext context, Request request) throws QingniaoRpcException;
}
