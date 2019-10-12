package com.printfcoder.micro.spring.core.codec.proto;

import com.printfcoder.micro.spring.core.codec.Codec;
import com.printfcoder.micro.spring.core.codec.Message;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.common.io.ReadWriteCloser;

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
    public void ReadBody(Object body) {
        if (body == null) {
            return;
        }


    }

    @Override
    public void Write(Message msg, Object obj) {
        if (!(obj instanceof com.google.protobuf.Message)) {
            return;
        }

        byte[] payLoadData = ((com.google.protobuf.Message) msg).toByteArray();

        this.conn.

        return;
    }


    @Override
    public void Close() throws MicroRpcException {

    }
}
