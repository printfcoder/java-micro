package mu.micro.java.framework.core.common.error;


public class MicroError implements Error {
    private int code;
    private String error;

    public MicroError(int code, String error) {
        this.code = code;
        this.error = error;
    }

    @Override
    public String Error() {
        return this.error;
    }

    @Override
    public int code() {
        return this.code;
    }
}
