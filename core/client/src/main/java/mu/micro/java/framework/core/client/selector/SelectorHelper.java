package mu.micro.java.framework.core.client.selector;

import mu.micro.java.framework.core.registry.Endpoint;
import mu.micro.java.framework.core.registry.Node;
import mu.micro.java.framework.core.registry.Registry;
import mu.micro.java.framework.core.registry.Service;

import java.util.ArrayList;
import java.util.List;


public class SelectorHelper {
    public static Option setRegistry(Registry registry) {
        return o -> o.setRegistry(registry);
    }

    /**
     * WithFilter adds a filter function to the list of filters used during the Select call.
     *
     * @param filters
     * @return
     */
    public static SelectOption withFilter(List<Filter> filters) {
        return o -> o.setFilters(filters);
    }

    /**
     * sets the selector strategy
     *
     * @param strategy
     * @return
     */
    public static SelectOption withStrategy(Strategy strategy) {
        return o -> o.setStrategy(strategy);
    }

    /**
     * filterEndpoint is an endpoint based Select Filter which will only return services with the endpoint specified.
     *
     * @param name
     * @return
     */
    public static Filter filterEndpoint(String name) {
        return old -> {
            List<Service> services = new ArrayList<>();
            for (Service oldS : old) {
                for (Endpoint ep : oldS.getEndpoints()) {
                    if (ep.getName().equals(name)) {
                        services.add(oldS);
                    }
                }
            }

            return services;
        };
    }

    /**
     * filterLabel is a label based Select Filter which will only return services with the label specified.
     *
     * @param key
     * @param value
     * @return
     */
    public static Filter filterLabel(String key, String value) {
        return old -> {
            List<Service> services = new ArrayList<>();
            for (Service oldS : old) {
                List<Node> nodes = new ArrayList<>();

                for (Node node : oldS.getNodes()) {
                    if (node.getMetadata() == null || node.getMetadata().size() == 0) {
                        continue;
                    }

                    if (value.equals(node.getMetadata().get(key))) {
                        nodes.add(node);
                    }
                }

                if (nodes.size() > 0) {
                    Service newOne = copyService(oldS);
                    newOne.setNodes(nodes);
                    services.add(newOne);
                }
            }
            return services;
        };
    }

    public static Filter filterVersion(String version) {
        return old -> {
            List<Service> services = new ArrayList<>();

            for (Service service : old) {
                if(version.equals(service.getVersion())){
                    services.add(service);
                }
            }

            return services;
        };
    }

    private static Service copyService(Service old) {
        Service s = new Service();
        s.setName(old.getName());
        s.setVersion(old.getVersion());
        s.setEndpoints(old.getEndpoints());
        s.setMetadata(old.getMetadata());
        s.setNodes(old.getNodes());
        return s;
    }
}
