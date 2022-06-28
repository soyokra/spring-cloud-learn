package com.soyokra.kernel.support.lib;

import lombok.Data;

import java.io.Serializable;

@Data
public class StdResponse<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public StdResponse() {

    }

    public StdResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> StdResponse<T> success() {
        return new StdResponse<>(1, "success", null);
    }

    public static <T> StdResponse<T> success(T data) {
        return new StdResponse<>(1, "success", data);
    }

    public static <T> StdResponse<T> error(int code, String message, T data) {
        return new StdResponse<>(code, message, data);
    }

    public static <T> StdResponse<T> error(int code, String message) {
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
