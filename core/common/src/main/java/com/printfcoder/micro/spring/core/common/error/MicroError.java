package com.printfcoder.micro.spring.core.common.error;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public class MicroError implements Error {
    private int code;
    private String error;

    public MicroError(int code, String error) {
        this.code = code;
        this.error = error;
    }

    @Override
    public String Error() {
        return this.error;
    }

    @Override
    public int code() {
        return this.code;
    }
}
