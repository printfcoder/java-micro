package com.printfcoder.micro.spring.core.codec;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/25
 **/
public interface Marshaler {
    byte[] marshal(Object obj);

    void unmarshal(byte[] bytes, Object obj);
}
