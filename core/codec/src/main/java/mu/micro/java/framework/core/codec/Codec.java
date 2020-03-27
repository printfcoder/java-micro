package mu.micro.java.framework.core.codec;

import mu.micro.java.framework.core.common.exception.MicroException;


public interface Codec extends Reader, Writer {
    void close() throws MicroException;
}
