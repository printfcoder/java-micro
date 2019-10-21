package com.printfcoder.micro.spring.core.codec;

import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/25
 **/
public interface Codec extends Reader, Writer {
    void close() throws MicroRpcException;
}
