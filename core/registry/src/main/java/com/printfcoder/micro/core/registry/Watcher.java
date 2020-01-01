package com.printfcoder.micro.core.registry;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
public interface Watcher {
    WatchResult next();
    void stop();
}
