package com.liujf.springboot02.vo;

import java.io.Serializable;

public class ResponseVO<T> implements Serializable {
    private static final long serialVersionUID = -6925010887949792100L;
    private Integer code;
    private String message;
    private T data;

    public static ResponseVO success(){
        ResponseVO res = new ResponseVO();
        res.code = 0;
        res.message = "success!";
        return res;
    }

    public static <T> ResponseVO success(T data){
        ResponseVO<T> res = new ResponseVO<T>();
        res.code = 0;
        res.message = "success!";
        res.data = data;
        return res;
    }

    public static ResponseVO failure(String msg){
        ResponseVO res = new ResponseVO();
        res.code = 1;
        res.message = msg;
        return res;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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