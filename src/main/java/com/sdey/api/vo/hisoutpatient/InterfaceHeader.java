package com.sdey.api.vo.hisoutpatient;

/**
 * Created by liudo on 2017/3/17 0017.
 */
public class InterfaceHeader {
    private String action;
    private String errreason;
    private String requestseq;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getErrreason() {
        return errreason;
    }

    public void setErrreason(String errreason) {
        this.errreason = errreason;
    }

    public String getRequestseq() {
        return requestseq;
    }

    public void setRequestseq(String requestseq) {
        this.requestseq = requestseq;
    }

    @Override
    public String toString() {
        return "InterfaceHeader{" +
                "action='" + action + '\'' +
                ", errreason='" + errreason + '\'' +
                ", requestseq='" + requestseq + '\'' +
                '}';
    }
}
