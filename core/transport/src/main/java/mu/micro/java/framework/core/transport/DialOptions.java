package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.context.QingniaoContext;
import lombok.Data;

import java.time.Duration;


@Data
public class DialOptions {
    // tells the transport this is a streaming connection with
    // multiple calls to send/recv and that send may not even be called
    private Boolean stream;

    // timeout for dialing
    private Duration timeout;

    // other options for implementations of the interface
    // can be stored in a context
    private QingniaoContext context;
}
