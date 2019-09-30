package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
@Data
public class ListenOptions {
    // other options for implementations of the interface
    // can be stored in a context
    private MicroContext context;
}
