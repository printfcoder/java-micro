package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;


@Data
public class WatchOptions {
    private String service;
    private MicroContext context;
}
