package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.common.error.MicroError;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@Data
public class RetryParams {
    private MicroContext context;
    private Request request;
    private int retryCount;
    private MicroError err;
}
