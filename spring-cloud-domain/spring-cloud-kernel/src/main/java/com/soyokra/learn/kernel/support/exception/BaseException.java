package com.soyokra.learn.kernel.support.exception;

public class BaseException extends Exception {
    protected Integer code;

    protected String message;

    public BaseException(ExceptionModel exceptionModel) {
        super(exceptionModel.getMessage());
        this.code = exceptionModel.getCode();
        this.message = exceptionModel.getMessage();
    }

    public BaseException(ExceptionModel exceptionModel, String message) {
        super(exceptionModel.getMessage());
        this.code = exceptionModel.getCode();
        this.message = message;
    }


    public BaseException(String message) {
        this(message, (Throwable)null);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
