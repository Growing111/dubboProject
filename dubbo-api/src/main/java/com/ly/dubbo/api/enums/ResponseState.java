package com.ly.dubbo.api.enums;

public enum ResponseState {

    SUSESS("200","请求成功"),
    EXCEPTION("400","请求异常"),
    ERROR("500","请求错误");

    public String code;
    public String message;

    ResponseState(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
