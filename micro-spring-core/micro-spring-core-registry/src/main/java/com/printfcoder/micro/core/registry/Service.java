package com.printfcoder.micro.core.registry;

import com.printfcoder.micro.spring.core.metadata.Metadata;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
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
