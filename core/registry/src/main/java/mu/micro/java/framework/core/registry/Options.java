package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;

import java.time.Duration;


@Data
public class Options {
    private String[] addrs;
    private Duration timeout = Duration.ZERO;
    private Boolean secure;
    // todo tls
    // private TLSConfig tls;
    private MicroContext context;
}
