package mu.micro.java.framework.core.registry;


public interface Watcher {
    WatchResult next();
    void stop();
}
