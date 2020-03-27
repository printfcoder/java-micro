package mu.micro.java.framework.core.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MicroContext implements Cloneable {

    private static final ThreadLocal<MicroContext> local = new ThreadLocal();

    public static void setContext(MicroContext context) {
        local.set(context);
    }

    private Map<String, Object> values = new ConcurrentHashMap<String, Object>();

    public static MicroContext getContext() {
        MicroContext context = local.get();
        if (context == null) {
            context = new MicroContext();
            local.set(context);
        }

        return context;
    }

    public MicroContext setValue(String key, Object value) {
        if (key != null) {
            if (value == null) {
                values.remove(key);
            } else {
                values.put(key, value);
            }
        }

        return this;
    }

    public Object getValue(String key) {
        return values.get(key);
    }
}
