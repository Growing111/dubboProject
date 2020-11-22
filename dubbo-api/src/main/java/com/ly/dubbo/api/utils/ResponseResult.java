package com.ly.dubbo.api.utils;

import com.ly.dubbo.api.enums.ResponseState;

import java.io.Serializable;

public class ResponseResult<T>  implements Serializable {

    private String code = ResponseState.SUSESS.getCode();
    private String message = ResponseState.SUSESS.getMessage();
    private T data;

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
