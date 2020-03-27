package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;

import java.time.Duration;


@Data
public class RegisterOptions {
    private Duration ttl;
    private MicroContext context;
}
