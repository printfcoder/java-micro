package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.core.registry.Registry;
import com.printfcoder.micro.spring.core.broker.Broker;
import com.printfcoder.micro.spring.core.client.selector.Selector;
import com.printfcoder.micro.spring.core.codec.NewCodec;
import com.printfcoder.micro.spring.core.transport.Transport;
import lombok.Data;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
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

    private MicroContext context;
}
