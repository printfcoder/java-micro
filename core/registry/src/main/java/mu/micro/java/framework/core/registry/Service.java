package mu.micro.java.framework.core.registry;

import mu.micro.java.framework.core.metadata.Metadata;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Service implements Serializable, Cloneable {
    private String name;
    private String version;
    private Metadata metadata;
    private List<Endpoint> endpoints;
    private List<Node> nodes;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
