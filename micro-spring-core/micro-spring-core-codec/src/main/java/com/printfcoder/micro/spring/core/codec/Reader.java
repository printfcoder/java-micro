package com.printfcoder.micro.spring.core.codec;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/26
 **/
public interface Reader {
    void ReadHeader(Message msg, int msgType);

    void ReadBody(Object body);
}
