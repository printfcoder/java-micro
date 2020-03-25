package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.metadata.Metadata;
import lombok.Data;

import java.io.Serializable;


@Data
public class Endpoint implements Serializable {
    private String name;
    private Value request;
    private Value response;
    private Metadata metadata;
}
