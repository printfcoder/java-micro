package mu.micro.java.framework.core.client.pool;

import mu.micro.java.framework.core.transport.Transport;
import lombok.Data;

import java.time.Duration;


@Data
public class Options {
    Transport transport;
    Duration tTL;
    int size;
}
