package mu.micro.java.framework.core.client;


public interface RetryOnError extends RetryFunc {

    @Override
    default Boolean apply(RetryParams retryParams) {
        if (retryParams.getErr() == null) {
            return false;
        }

        switch (retryParams.getErr().code()) {
            case 408:
            case 500:
                return true;
            default:
                return false;
        }
    }
}
