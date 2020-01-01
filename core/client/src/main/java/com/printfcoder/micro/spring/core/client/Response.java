package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.spring.core.codec.Reader;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;

import java.util.Map;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
public interface Response {
    // Read the response
    Reader codec();

    // read the header
    Map<String, String> header();

    // Read the response not decoded
    byte[] read() throws MicroRpcException;
}
