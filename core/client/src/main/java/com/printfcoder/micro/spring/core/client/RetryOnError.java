package com.printfcoder.micro.spring.core.client;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface RetryOnError extends RetryFunc {

    @Override
    default Boolean apply(RetryParams retryParams) {
        if (retryParams.getErr() == null) {
            return false;
        }

        switch (retryParams.getErr().code()) {
            case 408:
            case 500:
                return true;
            default:
                return false;
        }
    }
}
