package mu.micro.java.framework.core.codec;

import lombok.Data;

import java.util.HashMap;


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
