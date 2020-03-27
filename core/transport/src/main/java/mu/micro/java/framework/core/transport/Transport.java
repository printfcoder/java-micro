package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.common.exception.MicroException;


public interface Transport {
    void init(Option... opts) throws MicroException;

    Options options();

    Client dial(String addr, DialOption... opts) throws MicroException;

    Listener listen(String addr, ListenOption... opts) throws MicroException;

    String string();
}
