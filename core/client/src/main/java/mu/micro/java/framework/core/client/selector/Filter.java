package mu.micro.java.framework.core.client.selector;

import mu.micro.java.framework.core.registry.Service;

import java.util.List;
import java.util.function.Function;


public interface Filter extends Function<List<Service>, List<Service>> {
}
