package mu.micro.java.framework.core.codec;


public interface Writer {
    void write(Message msg, Object obj);
}
