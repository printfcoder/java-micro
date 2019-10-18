package com.printfcoder.micro.spring.core.codec;

import java.io.IOException;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/26
 **/
public interface Reader {
    void ReadHeader(Message msg, int msgType);

    Object ReadBody() throws IOException;
}
