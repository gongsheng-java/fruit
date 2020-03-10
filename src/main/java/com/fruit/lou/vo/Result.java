package com.fruit.lou.vo;

/**
 * @author gs
 * @Description TODO
 * @Date 2020-02-29 21:35
 */
public class Result<T> {

    private int code;

    private String msg;

    private String state;

    private T data;

    public static <T> Result<T> buildSuccssResult(T t){
        Result result = new Result();
        result.setState("ok");
        result.setCode(200);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> buildFailResult(String msg){
        Result result = new Result();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
