package mu.micro.java.framework.core.client;

import java.time.Duration;
import java.util.function.Function;


public interface BackOffFunc extends Function<BackOffParams, Duration> {
}
