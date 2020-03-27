package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.codec.Reader;

import java.util.Map;

public interface Message {
    // Topic of the message
    String getTopic();

    // The decoded payload value
    // todo Object to interface
    Object getPayload();

    // The content type of the payload
    String getContentType();

    // The raw headers of the message
    Map<String, String> getHeader();

    // The raw body of the message
    byte[] getBody();

    // Codec used to decode the message
    Reader getCodec();
}
