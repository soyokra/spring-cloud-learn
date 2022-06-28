package com.soyokra.learn.kernel.support.exception;


// 认证异常
public class AuthException extends BaseException {
    public AuthException(ExceptionModel exceptionModel) {
        super(exceptionModel);
    }
    public AuthException(ExceptionModel exceptionModel, String message) {
        super(exceptionModel, message);
    }
}
