package com.printfcoder.micro.spring.core.codec;

import lombok.Data;

import java.util.HashMap;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/26
 **/
@Data
public class Message {
    private String id;
    private Integer type;
    private String target;
    private String method;
    private String endpoint;
    private String error;
    
    private HashMap<String, String> header;
    private byte[] body;
}
