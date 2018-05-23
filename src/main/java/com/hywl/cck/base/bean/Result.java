package com.hywl.cck.base.bean;

import java.io.Serializable;

/**
 *
 * 返回消息对象
 *
 */
public class Result implements Serializable {
	private static final long serialVersionUID = 6925427825880496224L;
	private int status; // 状态码̬
	private String message; // 消息
	private Object data;// 数据
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	
}
