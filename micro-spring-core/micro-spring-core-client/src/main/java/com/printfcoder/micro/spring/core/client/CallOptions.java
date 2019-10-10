package com.printfcoder.micro.spring.core.client;

import com.printfcoder.micro.spring.core.client.selector.SelectOption;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/8
 **/
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
