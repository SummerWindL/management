package com.hywl.cck.base.admin;

import com.google.common.base.Strings;

/**
 * 前端请求消息类
 * 控制层向前端返回消息
 * @author yechao
 * @author Scott Chen
 *
 */
public class Result {

	public static final String RESP_IS_DISPLAY_VERIFYCODE = "isDisplayVerifyCode";

	/** 状态码, 正常0, 失败1, 未登录2, 个位数是保留状态码, 其他业务相关状态码10以上 */
	private String code = ResultCodeEnum.SUCCESS.getCode();

	/** 消息 */
	private String msg;

	/** 业务数据 */
	private Object data;

	public Result() {
	}

	public String getCode() {
		return code;
	}


	public String getMsg() {
		return msg;
	}


	public Object getData() {
		return data;
	}

	public static Builder builder() {
		return new Builder();
	}
	public static Builder builder(String code, String msg) {
		return new Builder(code, msg);
	}
	public static Builder builder(String code, String msg, Object data) {
		return new Builder(code, msg, data);
	}


	//---------- 直接返回结果 ----------

	public static Result success(Object object) {
		return new Builder(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), object).build();
	}
	public static Result success(String code, String msg, Object object) {
		return new Builder(code, msg, object).build();
	}
	public static Result success(String msg) {
		return new Builder(ResultCodeEnum.SUCCESS.getCode(), msg).build();
	}
	public static Result error(String code, String msg) {
		return new Builder(code, msg).build();
	}
	public static Result error(String msg) {
		return new Builder(ResultCodeEnum.FAILURE.getCode(), msg).build();
	}
	public static Result error(String code, String msg, Object object) {
		return new Builder(code, msg, object).build();
	}

	/**
	 * 消息构建器类
	 */
	public static class Builder {
		private String code;
		private String msg;
		private Object data;

		public Builder() {
			this.code = ResultCodeEnum.SUCCESS.getCode();
			this.msg = ResultCodeEnum.SUCCESS.getMsg();
			this.data = null;
		}

		public Builder(String code, String msg) {
			this.code = Strings.isNullOrEmpty(code) ? ResultCodeEnum.SUCCESS.getCode() : code;
			this.msg = Strings.isNullOrEmpty(msg) ? ResultCodeEnum.SUCCESS.getMsg() : msg;
		}

		public Builder(String code, String msg, Object extend) {
			this.code = Strings.isNullOrEmpty(code) ? ResultCodeEnum.SUCCESS.getCode() : code;
			this.msg = Strings.isNullOrEmpty(msg) ? ResultCodeEnum.SUCCESS.getMsg() : msg;
			this.data = extend;
		}

		public Result build() {
			Result message = new Result();
			message.code = this.code;
			message.msg = this.msg;
			message.data = this.data;
			return message;
		}

		public Builder setCode(String code) {
			this.code = code;
			return this;
		}

		public Builder setMsg(String msg) {
			this.msg = msg;
			return this;
		}

		public Builder setData(Object data) {
			this.data = data;
			return this;
		}
	}

}
