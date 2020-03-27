package mu.micro.java.framework.core.server;

import lombok.Data;
import mu.micro.java.framework.core.context.MicroContext;

@Data
public class SubscriberOptions {
    private boolean autoAck;
    private String queue;
    private boolean internal;
    private MicroContext context;
}
