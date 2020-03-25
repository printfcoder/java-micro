package mu.micro.java.framework.core.broker;

import mu.micro.java.framework.core.codec.Marshaler;
import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;


@Data
public class Options {
    private String[] addrs;
    private Boolean secure = false;
    private Marshaler codec;

    // todo TLS
    // private

    private QingniaoContext context;
}
