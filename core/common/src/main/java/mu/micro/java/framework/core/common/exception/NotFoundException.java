package mu.micro.java.framework.core.common.exception;

import lombok.Data;


@Data
public class NotFoundException extends RuntimeException {
    protected NotFoundException() {
        super("service not found");
    }
}
