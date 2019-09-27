package com.printfcoder.micro.spring.core.client.selector;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.broker.Broker;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/25
 **/
@Data
public class Options {
    private String contentType;

    // todo broker
    private Broker broker;

    // todo TLS
    // private TLSConfig tLSConfig;

    private MicroContext context;
}
