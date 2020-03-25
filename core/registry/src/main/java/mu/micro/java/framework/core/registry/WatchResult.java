package mu.micro.java.framework.core.registry;

import lombok.Data;


@Data
public class WatchResult {
    private String action;
    private Service service;
}
