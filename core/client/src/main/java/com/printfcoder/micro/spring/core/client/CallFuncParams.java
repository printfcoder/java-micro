package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.core.registry.Node;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@Data
public class CallFuncParams {
    private MicroContext context;
    private Node node;
    private Request req;
    private Object rsp;
    private CallOptions opts;
}
