package mu.micro.java.framework.core.common.exception;

import lombok.Data;


@Data
public class MicroException extends RuntimeException {
    protected int errorCode;

    protected MicroException() {

    }

    public MicroException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public MicroException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public MicroException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }
}
