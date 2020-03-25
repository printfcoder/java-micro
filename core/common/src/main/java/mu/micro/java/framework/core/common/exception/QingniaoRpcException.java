package mu.micro.java.framework.core.common.exception;

import lombok.Data;


@Data
public class QingniaoRpcException extends RuntimeException {
    protected int errorCode;

    protected QingniaoRpcException() {

    }

    public QingniaoRpcException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public QingniaoRpcException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public QingniaoRpcException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }
}
