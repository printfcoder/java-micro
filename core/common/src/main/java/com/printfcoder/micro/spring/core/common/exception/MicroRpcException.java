package com.printfcoder.micro.spring.core.common.exception;

import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/26
 **/
@Data
public class MicroRpcException extends RuntimeException {
    protected int errorCode;

    protected MicroRpcException() {

    }

    public MicroRpcException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public MicroRpcException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public MicroRpcException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }
}
