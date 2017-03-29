package com.sdey.api.vo.hisoutpatient;

import java.util.List;

/**
 * Created by liudo on 2017/3/17 0017.
 */
public class InterfaceInfo {
    private Integer code;
    private List<PatinetInfo> data;
    private InterfaceHeader header;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<PatinetInfo> getData() {
        return data;
    }

    public void setData(List<PatinetInfo> data) {
        this.data = data;
    }

    public InterfaceHeader getHeader() {
        return header;
    }

    public void setHeader(InterfaceHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "InterfaceInfo{" +
                "code=" + code +
                ", data=" + data +
                ", header=" + header +
                '}';
    }
}
