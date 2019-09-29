package com.printfcoder.micro.spring.core.client.selector;

import com.printfcoder.micro.core.registry.Service;

import java.util.List;
import java.util.function.Function;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public interface Filter extends Function<List<Service>, List<Service>> {
}
