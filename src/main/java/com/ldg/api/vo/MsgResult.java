package com.ldg.api.vo;

/**
 * Created by liudo on 2017/3/23 0023.
 */
public class MsgResult {
    private int code;
    private String message;
    private String id;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MsgResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
