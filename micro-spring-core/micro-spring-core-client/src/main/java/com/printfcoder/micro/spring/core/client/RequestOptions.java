package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@Data
public class RequestOptions {
    String contentType;
    boolean stream;

    // Other options for implementations of the interface
    // can be stored in a context
    MicroContext context;
}
