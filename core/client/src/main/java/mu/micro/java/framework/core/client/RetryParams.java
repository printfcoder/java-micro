package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.error.MicroError;
import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;


@Data
public class RetryParams {
    private MicroContext context;
    private Request request;
    private int retryCount;
    private MicroError err;
}
