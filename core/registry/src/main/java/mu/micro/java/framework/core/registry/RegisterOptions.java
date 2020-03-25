package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;

import java.time.Duration;


@Data
public class RegisterOptions {
    private Duration ttl;
    private QingniaoContext context;
}
