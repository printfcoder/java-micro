package com.printfcoder.micro.spring.core.common.exception;

import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
@Data
public class NotFoundException extends RuntimeException {
    protected NotFoundException() {
        super("service not found");
    }
}
