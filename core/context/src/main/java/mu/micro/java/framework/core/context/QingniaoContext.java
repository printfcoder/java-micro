package mu.micro.java.framework.core.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class QingniaoContext implements Cloneable {

    private static final ThreadLocal<QingniaoContext> local = new ThreadLocal();

    public static void setContext(QingniaoContext context) {
        local.set(context);
    }

    private Map<String, Object> values = new ConcurrentHashMap<String, Object>();

    public static QingniaoContext getContext() {
        QingniaoContext context = local.get();
        if (context == null) {
            context = new QingniaoContext();
            local.set(context);
        }

        return context;
    }

    public QingniaoContext setValue(String key, Object value) {
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
