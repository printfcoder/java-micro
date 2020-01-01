package com.printfcoder.micro.core.registry;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

import java.time.Duration;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
@Data
public class Options {
    private String[] addrs;
    private Duration timeout;
    private Boolean secure;
    // todo tls
    // private TLSConfig tls;
    private MicroContext context;
}
