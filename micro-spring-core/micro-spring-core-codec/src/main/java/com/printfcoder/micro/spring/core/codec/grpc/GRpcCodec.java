package com.printfcoder.micro.spring.core.codec.grpc;

import com.printfcoder.micro.spring.core.codec.Message;
import com.printfcoder.micro.spring.core.codec.MessageType;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.common.io.ReadWriteCloser;
import com.printfcoder.micro.spring.core.common.io.Reader;
import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/11
 **/
@Data
public class GRpcCodec {

    private static int maxMessageSize = 1024 * 1024 * 4;
    private static int maxInt = 0;

    private ReadWriteCloser conn;
    private String contentType;

    public void readHeader(Message m, MessageType t) {
        String ct = m.getHeader().get("Content-Type");
        if (ct != null && ct.length() > 0) {
            this.contentType = ct;
        }

        // service method
        String path = m.getHeader().get(":path");
        if (path == null || path.length() == 0 || !path.startsWith("/")) {
            m.setTarget(m.getHeader().get("Micro-Service"));
            m.setEndpoint(m.getHeader().get("Micro-Endpoint"));
        } else {
            // [, a.package.Foo, Bar]
            String[] parts = path.split("/");
            if (parts.length != 3) {
                throw new MicroRpcException(500, "Unknown request path");
            }

            String[] service = parts[1].split(".");
            m.setEndpoint(String.join(".", service[service.length - 1], parts[2]));
            m.setTarget(String.join(".", service));
        }
    }


    public void readBody(Object b) {
        if (b == null) {
            return;
        }



    }

    private void decode(Reader r) {
        java.io.Reader

    }
}
