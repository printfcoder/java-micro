package com.printfcoder.micro.spring.core.client.selector;

import com.printfcoder.micro.core.registry.Service;

import java.util.function.Function;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public interface Strategy extends Function<Service[], Next> {
}
