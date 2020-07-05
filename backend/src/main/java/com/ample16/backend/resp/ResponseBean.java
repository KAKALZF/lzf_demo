package com.ample16.backend.resp;

//import com.datafocus.common.constant.WarnType;
//import com.datafocus.common.exception.ServiceException;

import java.io.Serializable;

/**
 * 前置响应
 * Created by layne on 2017/6/9.
 */
public class ResponseBean<T> implements Serializable {
    /**
     * 响应码
     */
    private int code;

    /**
     * 响应结果描述
     */
    private String message = "";

    /**
     * 响应数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public ResponseBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseBean setData(T data) {
        this.data = data;
        return this;
    }

    public static ResponseBean success() {
        return new ResponseBean().setCode(200).setMessage("success");
    }

    public static ResponseBean response() {
        return new ResponseBean();
    }

}
