package mu.micro.java.framework.core.common.struct;

import mu.micro.java.framework.core.common.error.Error;

public interface Func3<T, M, N> {
    void apply(T t, M m, N n) throws Exception;
}
