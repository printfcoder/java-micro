package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;


@Data
public class RequestOptions {
    String contentType;
    boolean stream;

    // Other options for implementations of the interface
    // can be stored in a context
    MicroContext context;
}
