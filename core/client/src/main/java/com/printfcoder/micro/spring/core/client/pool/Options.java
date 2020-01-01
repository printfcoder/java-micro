package com.printfcoder.micro.spring.core.client.pool;

import com.printfcoder.micro.spring.core.transport.Transport;
import java.time.Duration;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
@Data
public class Options {

    Transport transport;
    Duration tTL;
    int size;
}
