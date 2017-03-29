package com.sdey.api.vo.ext;

/**
 * Created by liudo on 2017/3/23 0023.
 */
public class FenpeiWorkPlus {
    private Integer pationtID;
    private String ksName;
    private String zgqk;//转归情况
    private String lxdh;//联系电话
    private String jtdh;//家庭电话

    public Integer getPationtID() {
        return pationtID;
    }

    public void setPationtID(Integer pationtID) {
        this.pationtID = pationtID;
    }

    public String getKsName() {
        return ksName;
    }

    public void setKsName(String ksName) {
        this.ksName = ksName;
    }

    public String getZgqk() {
        return zgqk;
    }

    public void setZgqk(String zgqk) {
        this.zgqk = zgqk;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getJtdh() {
        return jtdh;
    }

    public void setJtdh(String jtdh) {
        this.jtdh = jtdh;
    }

    @Override
    public String toString() {
        return "FenpeiWorkPlus{" +
                "pationtID=" + pationtID +
                ", ksName='" + ksName + '\'' +
                ", zgqk='" + zgqk + '\'' +
                ", lxdh='" + lxdh + '\'' +
                ", jtdh='" + jtdh + '\'' +
                '}';
    }
}
