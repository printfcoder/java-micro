package mu.micro.java.framework.core.client;


public interface RetryAlways extends RetryFunc {
    @Override
    default Boolean apply(RetryFunc retryFunc) {
        return true;
    }
}
