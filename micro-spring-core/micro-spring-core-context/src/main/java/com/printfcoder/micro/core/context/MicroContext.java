package com.printfcoder.micro.core.context;

/**
 * RPC context
 * <p>
 * thanks to com.alipay.sofa.rpc.context.RpcInternalContext
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019-09-2019/9/24
 **/
public class MicroContext implements Cloneable {

    private static final ThreadLocal<MicroContext> local = new ThreadLocal();

    public static void setContext(MicroContext context) {
        local.set(context);
    }

    public static MicroContext getContext() {
        MicroContext context = local.get();
        if (context == null) {
            context = new MicroContext();
            local.set(context);
        }
        return context;
    }
}
