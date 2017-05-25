package com.ldg.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultMsg implements Serializable {
    private final static List nullList=new ArrayList();
    private int errcode;
    private String errmsg;
    private Object data=nullList;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        if(data!=null){
            this.data = data;
        }
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
