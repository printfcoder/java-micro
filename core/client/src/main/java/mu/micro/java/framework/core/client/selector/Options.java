package mu.micro.java.framework.core.client.selector;

import mu.micro.java.framework.core.context.MicroContext;
import mu.micro.java.framework.core.registry.Registry;
import lombok.Data;


@Data
public class Options {
    private Registry registry;
    private Strategy strategy;
    private MicroContext context;
}
