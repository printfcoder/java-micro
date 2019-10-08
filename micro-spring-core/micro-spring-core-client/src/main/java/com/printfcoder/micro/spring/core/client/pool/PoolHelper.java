package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.transport.Transport;
import java.time.Duration;
import java.util.HashMap;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
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
