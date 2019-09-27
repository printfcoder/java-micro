package com.printfcoder.micro.core.registry;

import com.printfcoder.micro.spring.core.metadata.Metadata;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
@Data
public class Service implements Serializable {
    private String name;
    private String version;
    private Metadata metadata;
    private Endpoint[] endpoints;
    private Node[] nodes;
}
