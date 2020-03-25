package mu.micro.java.framework.core.codec;

import mu.micro.java.framework.core.common.io.ReadWriteCloser;

import java.util.function.Function;


public interface NewCodec extends Function<ReadWriteCloser, Codec> {
}
