package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;


@Data
public class ListenOptions {
    // other options for implementations of the interface
    // can be stored in a context
    private MicroContext context;
}
