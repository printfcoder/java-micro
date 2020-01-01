package com.printfcoder.micro.core.registry;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
@Data
public class WatchOptions {
    private String service;
    private MicroContext context;
}
