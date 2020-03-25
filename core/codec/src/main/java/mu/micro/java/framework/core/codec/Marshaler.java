package mu.micro.java.framework.core.codec;


public interface Marshaler {
    byte[] marshal(Object obj);

    void unmarshal(byte[] bytes, Object obj);
}
