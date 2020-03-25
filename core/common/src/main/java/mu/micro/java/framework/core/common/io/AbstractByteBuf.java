package mu.micro.java.framework.core.common.io;

public abstract class AbstractByteBuf {

    public abstract byte[] bytes();

    public abstract int readableBytes();

    public abstract boolean release();
}
