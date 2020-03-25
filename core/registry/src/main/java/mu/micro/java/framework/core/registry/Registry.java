package mu.micro.java.framework.core.registry;


import java.util.List;

public interface Registry {
    void init(Option... options);

    Options options();

    void register(Service service, RegisterOption... registerOptions);

    void deregister(Service service);

    List<Service> getService(String service);

    List<Service> listService();

    Watcher watch(WatchOption... watchOptions);

    String string();
}
