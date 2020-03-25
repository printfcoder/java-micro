package mu.micro.java.framework.core.codec;

import mu.micro.java.framework.core.common.exception.QingniaoRpcException;


public interface Codec extends Reader, Writer {
    void close() throws QingniaoRpcException;
}
