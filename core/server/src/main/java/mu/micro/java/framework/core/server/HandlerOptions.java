package mu.micro.java.framework.core.server;

import lombok.Data;
import mu.micro.java.framework.core.metadata.Metadata;

import java.util.Map;

@Data
public class HandlerOptions {
    boolean internal;
    Map<String, Metadata> metadata;
}
