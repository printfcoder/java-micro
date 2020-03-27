package mu.micro.java.framework.core.server;

import lombok.Data;
import mu.micro.java.framework.core.broker.Broker;
import mu.micro.java.framework.core.codec.NewCodec;
import mu.micro.java.framework.core.common.struct.Func;
import mu.micro.java.framework.core.common.struct.FuncVoid;
import mu.micro.java.framework.core.context.MicroContext;
import mu.micro.java.framework.core.metadata.Metadata;
import mu.micro.java.framework.core.registry.Registry;
import mu.micro.java.framework.core.transport.Transport;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Data
public class Options {
    private Map<String, NewCodec> codecs;
    private Broker broker;
    // todo Tracer;
    // todo A
    private Registry registry;
    private Transport transport;
    private Metadata metadata;
    private String name;
    private String address;
    private String advertise;
    private String id;
    private String version;
    private List<HandlerWrapper> handlerWrappers;
    private List<SubscriberWrapper> subscriberWrappers;

    // RegisterCheck runs a check function before registering the service
    private FuncVoid<MicroContext> registerCheck;
    private Duration registerTTL;
    private Duration registerInterval;

    // todo TLS

    private MicroContext context;
}
