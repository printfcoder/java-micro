package mu.micro.java.framework.core.server;

import com.sun.org.apache.xml.internal.security.Init;

public interface Server {
    Options getOptions();

    // todo Exception
    void init() throws Exception;

    void handle(Handler handler) throws Exception;
}
