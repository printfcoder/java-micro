package mu.micro.java.framework.core.broker;

import mu.micro.java.framework.core.codec.Marshaler;
import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;


@Data
public class Options {
    private String[] addrs;
    private Boolean secure = false;
    private Marshaler codec;

    // todo TLS
    // private

    private MicroContext context;
}
