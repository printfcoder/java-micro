package mu.micro.java.framework.core.codec;

import mu.micro.java.framework.core.common.io.AbstractByteBuf;

import java.io.IOException;


public interface Reader {
    void readHeader(Message msg, int msgType);

    Object readBody(AbstractByteBuf data) throws IOException;
}
