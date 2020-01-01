package com.printfcoder.micro.spring.core.transport;

import com.printfcoder.micro.core.context.MicroContext;
import com.printfcoder.micro.spring.core.codec.Marshaler;
import lombok.Data;

import java.time.Duration;
import java.util.List;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/30
 **/
@Data
public class Options {
    // addrs is the list of intermediary addresses to connect to
    private List<String> addrs;

    // codec is the codec interface to use where headers are not supported
    // by the transport and the entire payload must be encoded
    private Marshaler codec;

    // secure tells the transport to secure the connection.
    // In the case TLSConfig is not specified best effort self-signed
    // certs should be used
    private Boolean secure;

    // todo TLS

    // timeout sets the timeout for Send/Recv
    private Duration timeout;

    // other options for implementations of the interface
    // can be stored in a context
    private MicroContext context;
}
