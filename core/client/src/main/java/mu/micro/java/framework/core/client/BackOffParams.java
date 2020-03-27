package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;


@Data
public class BackOffParams {
    private MicroContext context;
    private Request request;
    private int attempts;
}
