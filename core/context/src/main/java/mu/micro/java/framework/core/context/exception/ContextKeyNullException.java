package mu.micro.java.framework.core.context.exception;


public class ContextKeyNullException extends RuntimeException {
    public ContextKeyNullException() {
        super("null key");
    }
}
