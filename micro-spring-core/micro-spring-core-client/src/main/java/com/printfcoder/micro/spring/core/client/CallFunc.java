package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.spring.core.common.error.MicroError;

import java.util.function.Function;

/**
 * CallFunc represents the individual call func
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface CallFunc extends Function<CallFuncParams, MicroError> {
}
