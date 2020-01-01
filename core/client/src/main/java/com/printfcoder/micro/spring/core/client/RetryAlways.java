package com.printfcoder.micro.spring.core.client;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface RetryAlways extends RetryFunc {
    @Override
    default Boolean apply(RetryFunc retryFunc) {
        return true;
    }
}
