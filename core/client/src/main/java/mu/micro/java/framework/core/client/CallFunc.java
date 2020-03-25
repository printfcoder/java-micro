package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.common.error.QingniaoError;

import java.util.function.Function;


public interface CallFunc extends Function<CallFuncParams, QingniaoError> {
}
