package mu.micro.java.framework.core.registry;

import lombok.Data;

import java.util.List;


@Data
public class Value {
    private String name;
    private String type;
    private String idx;
    private List<Value> values;
}
