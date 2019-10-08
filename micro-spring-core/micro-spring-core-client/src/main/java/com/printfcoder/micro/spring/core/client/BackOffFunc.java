package com.printfcoder.micro.spring.core.client;

import java.time.Duration;
import java.util.function.Function;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface BackOffFunc extends Function<BackOffParams, Duration> {
}
