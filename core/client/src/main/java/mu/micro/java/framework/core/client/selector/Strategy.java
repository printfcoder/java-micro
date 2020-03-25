package mu.micro.java.framework.core.client.selector;

import mu.micro.java.framework.core.registry.Service;

import java.util.function.Function;


public interface Strategy extends Function<Service[], Next> {
}
