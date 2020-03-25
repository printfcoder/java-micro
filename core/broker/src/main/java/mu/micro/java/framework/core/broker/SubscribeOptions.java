package mu.micro.java.framework.core.broker;

import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;


@Data
public class SubscribeOptions {
    private Boolean autoAck;
    private String queue;
    private QingniaoContext context;
}
