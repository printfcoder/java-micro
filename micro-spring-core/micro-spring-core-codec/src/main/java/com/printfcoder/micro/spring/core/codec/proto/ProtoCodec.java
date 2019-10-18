package com.printfcoder.micro.spring.core.codec.proto;

import com.printfcoder.micro.spring.core.codec.Codec;
import com.printfcoder.micro.spring.core.codec.Message;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.common.io.ReadWriteCloser;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/12
 **/

public class ProtoCodec implements Codec {
    private ReadWriteCloser conn;

    public ReadWriteCloser conn() {
        return this.conn;
    }

    @Override
    public void ReadHeader(Message msg, int msgType) {
        // do nothing
    }

    @Override
    public com.google.protobuf.Message ReadBody() throws IOException {
        byte[] buff = this.conn.readAll();

    }

    @Override
    public void Write(Message msg, Object obj) {
        if (!(obj instanceof com.google.protobuf.Message)) {
            return;
        }

        byte[] payLoadData = ((com.google.protobuf.Message) msg).toByteArray();
        this.conn.write(payLoadData);
    }


    @Override
    public void Close() throws MicroRpcException {
        try {
            this.conn.close();
        } catch (IOException e) {
            throw new MicroRpcException(500, e);
        }
    }

    private byte[] readyFully(InputStream in, int totalSize) {
        byte[] retval = new byte[totalSize];
        int bytesRead = 0;
        while (bytesRead < totalSize) {
            try {
                int read = in.read(retval, bytesRead, totalSize - bytesRead);
                if (read == -1) {
                    throw new MicroRpcException(500, "Unable to read complete request or response");
                }
                bytesRead += read;
            } catch (IOException e) {
                throw new MicroRpcException(500, "IOException reading data: " + e);
            }
        }
        return retval;
    }
}
