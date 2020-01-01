package com.printfcoder.micro.core.context.exception;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
public class ContextKeyNullException extends RuntimeException {
    public ContextKeyNullException() {
        super("null key");
    }
}
