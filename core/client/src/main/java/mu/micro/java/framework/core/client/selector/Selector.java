package mu.micro.java.framework.core.client.selector;

import mu.micro.java.framework.core.common.error.Error;
import mu.micro.java.framework.core.registry.Node;


public interface Selector {
    void init(Option... opts);

    Options getOptions();

    // select returns a function which should return the next node
    Next select(String service, SelectOption opts);

    // mark sets the success/error against a node
    void mark(String service, Node node, Error error);

    void reset(String service);

    void close();

    String string();
}
