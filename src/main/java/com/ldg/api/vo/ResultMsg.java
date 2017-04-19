package com.ldg.api.vo;

import com.kangkang.constant.SysConstant;

import java.io.Serializable;

public class ResultMsg implements Serializable{
	private int errcode;
	private String errmsg;
	private Object data;

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
		this.data = data;
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
