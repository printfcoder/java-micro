package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.context.MicroContext;
import mu.micro.java.framework.core.registry.Node;
import lombok.Data;


@Data
public class CallFuncParams {
    private MicroContext context;
    private Node node;
    private Request req;
    private Object rsp;
    private CallOptions opts;
}
