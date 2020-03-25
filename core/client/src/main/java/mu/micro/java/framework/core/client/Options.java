package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.broker.Broker;
import mu.micro.java.framework.core.client.selector.Selector;
import mu.micro.java.framework.core.codec.NewCodec;
import mu.micro.java.framework.core.context.QingniaoContext;
import mu.micro.java.framework.core.registry.Registry;
import mu.micro.java.framework.core.transport.Transport;
import lombok.Data;

import java.time.Duration;
import java.util.Map;


@Data
public class Options {
    private String contentType;

    private Broker broker;

    private Map<String, NewCodec> codecs;

    private Registry registry;

    private Selector selector;

    private Transport transport;

    private Integer poolSize;
    private Duration poolTTL;

    // todo wrapper

    // todo calloptions

    // todo TLS
    // private TLSConfig tLSConfig;

    private QingniaoContext context;
}
