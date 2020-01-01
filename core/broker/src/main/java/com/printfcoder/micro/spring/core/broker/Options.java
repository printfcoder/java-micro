package com.printfcoder.micro.spring.core.broker;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.codec.Marshaler;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/25
 **/
@Data
public class Options {
    private String[] addrs;
    private Boolean secure = false;
    private Marshaler codec;

    // todo TLS
    // private

    private MicroContext context;
}
