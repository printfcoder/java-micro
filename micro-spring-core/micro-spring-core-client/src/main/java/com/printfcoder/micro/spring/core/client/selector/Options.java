package com.printfcoder.micro.spring.core.client.selector;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.core.registry.Registry;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/25
 **/
@Data
public class Options {
    private Registry registry;
    private Strategy strategy;
    private MicroContext context;
}
