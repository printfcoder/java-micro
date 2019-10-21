package com.printfcoder.micro.spring.core.codec;

import com.printfcoder.micro.spring.core.common.io.AbstractByteBuf;

import java.io.IOException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/26
 **/
public interface Reader {
    void readHeader(Message msg, int msgType);

    Object readBody(AbstractByteBuf data) throws IOException;
}
