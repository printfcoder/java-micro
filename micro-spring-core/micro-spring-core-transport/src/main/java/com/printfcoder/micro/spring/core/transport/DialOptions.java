package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

import java.time.Duration;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
@Data
public class DialOptions {
    // tells the transport this is a streaming connection with
    // multiple calls to send/recv and that send may not even be called
    private Boolean stream;

    // timeout for dialing
    private Duration timeout;

    // other options for implementations of the interface
    // can be stored in a context
    private MicroContext context;
}
