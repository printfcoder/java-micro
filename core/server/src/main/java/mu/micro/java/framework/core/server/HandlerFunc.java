package mu.micro.java.framework.core.server;

import mu.micro.java.framework.core.common.struct.Func3;
import mu.micro.java.framework.core.context.MicroContext;

// todo Object to response
public interface HandlerFunc extends Func3<MicroContext, Request, Object> {
}
