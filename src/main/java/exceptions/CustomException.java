package exceptions;

public class CustomException extends RuntimeException {

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public enum ErrorCode {
        PARSE_ERROR
    }

    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}