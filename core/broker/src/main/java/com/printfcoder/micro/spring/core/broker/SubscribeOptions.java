package com.printfcoder.micro.spring.core.broker;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/26
 **/
@Data
public class SubscribeOptions {
    private Boolean autoAck;
    private String queue;
    private MicroContext context;
}
