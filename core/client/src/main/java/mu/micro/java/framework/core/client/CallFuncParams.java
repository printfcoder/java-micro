package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.context.QingniaoContext;
import mu.micro.java.framework.core.registry.Node;
import lombok.Data;


@Data
public class CallFuncParams {
    private QingniaoContext context;
    private Node node;
    private Request req;
    private Object rsp;
    private CallOptions opts;
}
