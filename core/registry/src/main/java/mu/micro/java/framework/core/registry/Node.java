package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.metadata.Metadata;
import lombok.Data;

import java.io.Serializable;


@Data
public class Node implements Serializable {
    private String id;
    private String address;
    private Metadata metadata;
}
