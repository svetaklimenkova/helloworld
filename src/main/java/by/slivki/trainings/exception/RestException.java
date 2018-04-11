package by.slivki.trainings.exception;

public class RestException extends RuntimeException {
    public static final String PREFIX = "error_";
    private int code;
    private String message;
    private Object[] args;

    public RestException(int code, String... args) {
        this.code = code;
        this.args = args;
        this.message = PREFIX + code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
