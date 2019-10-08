package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@Data
public class BackOffParams {
    private MicroContext context;
    private Request request;
    private int attempts;
}
