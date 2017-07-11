package com.mark.basemodule.base;

/**
 * Created by Mark.Han on 2017/7/10.
 */

public class BaseResponse<T> {
    public static final int CODE_FAILD = -1;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_TOKENERROR = -1024;


    private int status;
    private String msg;
    private int total;
    private T data;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
