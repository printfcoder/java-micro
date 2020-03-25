package mu.micro.java.framework.core.client;

import mu.micro.java.framework.core.client.selector.SelectOption;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.util.List;


@Data
public class CallOptions {
    private List<SelectOption> selectOptions;

    /**
     * Address of remote hosts
     */
    private List<String> address;

    /**
     * Backoff func
     */
    @Getter(AccessLevel.NONE)
    private BackOffFunc backOff;

    /**
     * Check if retryable func
     */
    @Getter(AccessLevel.NONE)
    private RetryFunc retry;

    /**
     * Transport Dial Timeout
     */
    private Duration dialTimeout;

    private int retries;

    private Duration requestTimeout;

    public BackOffFunc backOff() {
        return this.backOff;
    }

    public RetryFunc retry() {
        return this.retry;
    }
}
