package mu.micro.java.framework.core.codec.grpc;

import mu.micro.java.framework.core.codec.Message;
import mu.micro.java.framework.core.codec.MessageType;
import mu.micro.java.framework.core.common.exception.MicroException;
import mu.micro.java.framework.core.common.io.ReadWriteCloser;
import mu.micro.java.framework.core.common.io.Reader;
import lombok.Data;

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
                throw new MicroException(500, "Unknown request path");
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

    }
}
