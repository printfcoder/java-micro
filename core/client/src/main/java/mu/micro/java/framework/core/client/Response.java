package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.codec.Reader;
import mu.micro.java.framework.core.common.exception.QingniaoRpcException;

import java.util.Map;


public interface Response {
    // Read the response
    Reader codec();

    // read the header
    Map<String, String> header();

    // Read the response not decoded
    byte[] read() throws QingniaoRpcException;
}
