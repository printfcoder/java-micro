package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.spring.core.codec.Marshaler;

import java.time.Duration;
import java.util.List;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
public class TransportHelper {

    public static Option addrs(List<String> addrs) {
        return o -> o.setAddrs(addrs);
    }

    public static Option codec(Marshaler c) {
        return o -> o.setCodec(c);
    }

    public static Option timeout(Duration timeout) {
        return o -> o.setTimeout(timeout);
    }

    public static Option secure(boolean b) {
        return o -> o.setSecure(b);
    }

    public static DialOption withTimeout(Duration d) {
        return o -> o.setTimeout(d);
    }

    public static DialOption withStream(boolean stream) {
        return o -> o.setStream(stream);
    }
}
