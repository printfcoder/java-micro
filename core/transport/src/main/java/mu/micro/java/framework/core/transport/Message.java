package mu.micro.java.framework.core.transport;

import lombok.Data;

import java.util.HashMap;


@Data
public class Message {
    private HashMap<String, String> header;
    private byte[] body;
}
