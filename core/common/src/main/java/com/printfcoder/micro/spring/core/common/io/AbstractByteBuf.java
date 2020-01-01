package com.printfcoder.micro.spring.core.common.io;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/21
 **/
public abstract class AbstractByteBuf {

    public abstract byte[] bytes();

    public abstract int readableBytes();

    public abstract boolean release();
}
