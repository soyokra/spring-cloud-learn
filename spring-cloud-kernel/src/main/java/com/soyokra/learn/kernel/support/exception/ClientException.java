package com.soyokra.learn.kernel.support.exception;


// 请求异常
public class ClientException extends BaseException {
    public ClientException(ExceptionModel exceptionModel) {
        super(exceptionModel);
    }

    public ClientException(ExceptionModel exceptionModel, String message) {
        super(exceptionModel, message);
    }

    public ClientException(String message) {
        super(ExceptionModel.CLIENT, message);
    }
}
