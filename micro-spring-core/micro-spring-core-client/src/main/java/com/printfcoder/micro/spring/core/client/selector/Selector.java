package com.printfcoder.micro.spring.core.client.selector;

import com.printfcoder.micro.core.registry.Node;
import com.printfcoder.micro.spring.core.common.error.Error;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/25
 **/
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
