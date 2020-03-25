package mu.micro.java.framework.plugins.registry.zookeeper;

import mu.micro.java.framework.core.registry.*;
import org.apache.curator.framework.CuratorFramework;

import java.time.Duration;
import java.util.List;

public class ZookeeperRegistry implements Registry {

    private static final String prefix = "/micro-registry";
    /**
     * Zookeeper zkClient
     */
    private CuratorFramework zkClient;

    private Options options = new Options();


    @Override
    public void init(Option... options) {
        for (Option option : options) {
            option.apply(this.options);
        }

        if (this.options.getTimeout().isZero()) {
            this.options.setTimeout(Duration.ofSeconds(5));
        }

        // 连接Zk

        // 创建目录

        return;
    }

    @Override
    public Options options() {
        return null;
    }

    @Override
    public void register(Service service, RegisterOption... registerOptions) {

    }

    @Override
    public void deregister(Service service) {

    }

    @Override
    public List<Service> getService(String service) {
        return null;
    }

    @Override
    public List<Service> listService() {
        return null;
    }

    @Override
    public Watcher watch(WatchOption... watchOptions) {
        return null;
    }

    @Override
    public String string() {
        return "zookeeper";
    }
}
