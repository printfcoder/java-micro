package com.printfcoder.micro.spring.core.client;

import java.util.function.Function;

/**
 * note that returning either false or a non-nil error will result in the call not being retried
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface RetryFunc extends Function<RetryParams, Boolean> {
}
