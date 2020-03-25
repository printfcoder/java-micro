package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.transport.Transport;

import java.time.Duration;
import java.util.HashMap;


public class PoolHelper {

    public static Option size(int i) {
        return o -> o.setSize(i);
    }

    public static Option transport(Transport transport) {
        return o -> o.setTransport(transport);
    }

    public static Option ttl(Duration t) {
        return o -> o.setTTL(t);
    }

    public static Pool newPool(Options options) {
        return new DefaultPool(options.getSize(), options.getTTL(), options.getTransport(), new HashMap<>());
    }
}
