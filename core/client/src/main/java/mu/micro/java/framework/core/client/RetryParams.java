package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.error.QingniaoError;
import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;


@Data
public class RetryParams {
    private QingniaoContext context;
    private Request request;
    private int retryCount;
    private QingniaoError err;
}
