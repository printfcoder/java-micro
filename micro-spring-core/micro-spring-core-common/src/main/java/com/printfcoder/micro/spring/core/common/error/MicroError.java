package com.printfcoder.micro.spring.core.common.error;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public class MicroError implements Error {
    private String error;

    public MicroError(String error) {
        this.error = error;
    }

    @Override
    public String Error() {
        return this.error;
    }
}
