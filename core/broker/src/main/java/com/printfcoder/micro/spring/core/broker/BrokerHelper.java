package com.printfcoder.micro.spring.core.broker;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.core.registry.Registry;
import com.printfcoder.micro.spring.core.codec.Marshaler;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
public class BrokerHelper {

    public static SubscribeOptions newSubscribeOptions(SubscribeOption... opts) {
        SubscribeOptions opt = new SubscribeOptions();
        opt.setAutoAck(true);

        for (SubscribeOption o : opts) {
            o.apply(opt);
        }

        return opt;
    }

    // Addrs sets the host addresses to be used by the broker
    public static Option addrs(String... addrs) {
        return o -> o.setAddrs(addrs);
    }

    // Codec sets the codec used for encoding/decoding used where
    // a broker does not support headers
    public static Option codec(Marshaler c) {
        return o -> o.setCodec(c);
    }

    // DisableAutoAck will disable auto acking of messages
    // after they have been handled.
    public static SubscribeOption disableAutoAck() {
        return o -> o.setAutoAck(false);
    }

    // Queue sets the name of the queue to share messages on
    public static SubscribeOption queue(String name) {
        return o -> o.setQueue(name);
    }

    public static Option registry(Registry r) {
        return o -> o.setContext(MicroContext.getContext().setValue(Constants.BROKER_REGISTRY_KEY, r));
    }

    // Secure communication with the broker
    public static Option secure(boolean secure) {
        return o -> o.setSecure(secure);
    }

    // todo TLSConfig
}
