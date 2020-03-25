package mu.micro.java.framework.core.client;


public interface Message {
    String topic();
    Object payload();
    String contentType();
}
