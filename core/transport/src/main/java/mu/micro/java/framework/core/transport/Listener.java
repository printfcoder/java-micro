package mu.micro.java.framework.core.transport;

import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.common.struct.FuncVoid;


public interface Listener {
    String addr();

    void close();

    void accept(FuncVoid<Socket> func) throws MicroException;
}
