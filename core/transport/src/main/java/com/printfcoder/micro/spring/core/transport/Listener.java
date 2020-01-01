package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.common.struct.Func;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
public interface Listener {
    String addr();

    void close();

    void accept(Func<Socket> func) throws MicroRpcException;

}
