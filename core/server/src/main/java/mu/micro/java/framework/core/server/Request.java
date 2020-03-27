package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.codec.Reader;

import java.util.Map;

public interface Request {
    // Service name requested
    String getService();

    // The action requested
    String getMethod();

    // Endpoint name requested
    String getEndpoint();

    // Content type provided
    String getContentType();

    // Header of the request
    Map<String, String> getHeader();

    // Body is the initial decoded value
    Object getBody();

    // Read the undecoded request body
    // todo special Exception
    byte[] getRead() throws Exception;

    // The encoded message stream
    Reader getCodec();

    // Indicates whether its a stream
    boolean isStream();
}
