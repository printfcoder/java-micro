package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import sun.misc.Request;

import javax.xml.ws.Response;

/**
 * Router manages request routing
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
public interface Router {
    Response sendRequest(MicroContext context, Request request) throws MicroRpcException;
}
