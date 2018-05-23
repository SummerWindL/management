package com.hywl.cck.base.admin;

public enum ResultCodeEnum {
	/** 成功 */
	SUCCESS("0", "成功"),
	/** 失败 */
	FAILURE("1", "system.ex.msg.prefix"),
	/** 未登录/登录超时 */
	SESSION_TIMEOUT("2", "system.session.timeout");

	/** 状态码 */
	private String code;

	/** 信息 */
	private String msg;

	private ResultCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
