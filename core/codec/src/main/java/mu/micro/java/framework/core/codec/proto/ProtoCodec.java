package mu.micro.java.framework.core.codec.proto;

import mu.micro.java.framework.core.codec.Codec;
import mu.micro.java.framework.core.codec.Message;
import mu.micro.java.framework.core.common.exception.QingniaoRpcException;
import mu.micro.java.framework.core.common.io.AbstractByteBuf;
import mu.micro.java.framework.core.common.io.ReadWriteCloser;

import java.io.IOException;
import java.io.InputStream;

public class ProtoCodec implements Codec {
    private ReadWriteCloser conn;

    public ReadWriteCloser conn() {
        return this.conn;
    }

    @Override
    public void readHeader(Message msg, int msgType) {
        // do nothing
    }

    @Override
    public com.google.protobuf.Message readBody(AbstractByteBuf data) throws IOException {
        if (data == null || data.readableBytes() == 0) {
            // todo pb
        }

        return null;
    }

    @Override
    public void write(Message msg, Object obj) {
        if (!(obj instanceof com.google.protobuf.Message)) {
            return;
        }

        byte[] payLoadData = ((com.google.protobuf.Message) msg).toByteArray();
        this.conn.write(payLoadData);
    }


    @Override
    public void close() throws QingniaoRpcException {
        try {
            this.conn.close();
        } catch (IOException e) {
            throw new QingniaoRpcException(500, e);
        }
    }

    private byte[] readyFully(InputStream in, int totalSize) {
        byte[] retval = new byte[totalSize];
        int bytesRead = 0;
        while (bytesRead < totalSize) {
            try {
                int read = in.read(retval, bytesRead, totalSize - bytesRead);
                if (read == -1) {
                    throw new QingniaoRpcException(500, "Unable to read complete request or response");
                }
                bytesRead += read;
            } catch (IOException e) {
                throw new QingniaoRpcException(500, "IOException reading data: " + e);
            }
        }
        return retval;
    }
}
