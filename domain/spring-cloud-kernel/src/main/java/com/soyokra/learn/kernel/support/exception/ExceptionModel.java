package com.soyokra.learn.kernel.support.exception;

public enum ExceptionModel {
    SUCCESS(0, "success"),

    /****************system-error*********************/
    // 100004xx ~ 10000499
    CLIENT(10000400, "客户端错误"),
    CLIENT_AUTH(10000401, "认证错误"),
    CLIENT_AUTH_LOGIN(10000402, "用户名或密码错误"),
    CLIENT_AUTH_TOKEN(10000403, "token认证错误"),
    CLIENT_AUTH_PERMISSION(10000404, "权限错误"),
    CLIENT_VALIDATE(10000405, "参数错误"),

    // 100005xx ~ 10000599
    SERVER(10000500, "服务器内部错误"),
    SERVER_REMOTE_REQUEST(10000501, "远程http请求错误"),

    /****************domain-error*********************/
    // 100006xx开始 无需分业务, 直接按照+1递增
    ;

    private Integer code;

    private String message;

    ExceptionModel(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
