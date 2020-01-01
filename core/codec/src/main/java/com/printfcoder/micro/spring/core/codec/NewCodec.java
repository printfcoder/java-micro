package com.printfcoder.micro.spring.core.codec;

import com.printfcoder.micro.spring.core.common.io.ReadWriteCloser;

import java.util.function.Function;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public interface NewCodec extends Function<ReadWriteCloser, Codec> {
}
