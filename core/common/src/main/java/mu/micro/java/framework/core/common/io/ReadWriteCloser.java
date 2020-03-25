package mu.micro.java.framework.core.common.io;


public interface ReadWriteCloser extends Reader, Writer {
    int write(byte[] bytes);
}
