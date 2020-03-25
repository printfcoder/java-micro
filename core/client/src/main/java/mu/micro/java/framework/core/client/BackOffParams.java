package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;


@Data
public class BackOffParams {
    private QingniaoContext context;
    private Request request;
    private int attempts;
}
