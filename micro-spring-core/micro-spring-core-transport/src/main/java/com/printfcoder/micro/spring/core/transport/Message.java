package com.printfcoder.micro.spring.core.transport;

import lombok.Data;

import java.util.HashMap;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
@Data
public class Message {
    private HashMap<String, String> header;
    private byte[] body;
}
