package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;


@Data
public class WatchOptions {
    private String service;
    private QingniaoContext context;
}
