package com.printfcoder.micro.core.registry;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
public interface Registry {
    void init(Option... options);

    Options options();

    void register(Service service, RegisterOption... registerOptions);

    void deregister(Service service);

    Service[] getService(String service);

    Service[] listService();

    Watcher watch(WatchOption... watchOptions);

    String string();
}
