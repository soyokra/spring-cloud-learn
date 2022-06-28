package com.soyokra.learn.kernel.support.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseUtils<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public ResponseUtils() {

    }

    public ResponseUtils(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseUtils<T> success() {
        return new ResponseUtils<>(1, "success", null);
    }

    public static <T> ResponseUtils<T> success(T data) {
        return new ResponseUtils<>(0, "success", data);
    }

    public static <T> ResponseUtils<T> error(int code, String message, T data) {
        return new ResponseUtils<>(code, message, data);
    }

    public static <T> ResponseUtils<T> error(int code, String message) {
        return error(code, message, null);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }
}
