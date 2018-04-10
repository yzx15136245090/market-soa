package com.zzti.market.entity;

import java.io.Serializable;

public class Result implements Serializable{
	public transient final static int JSON_SUCCESSED_RESPONSE = 1;

	public transient final static int JSON_FAILED_RESPONSE = -1;

	public Result() {
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(Object data) {
		this.data = data;
	}

	/**
	 * 错误编号 >=1表示成功  <=-1表示失败
	 */
	protected int code = JSON_SUCCESSED_RESPONSE;
	/**
	 * 错误信息
	 */
	protected String message = "成功";
	/**
	 * 返回的具体实体对象
	 */
	protected Object data = null;

	@Deprecated
	public static Result errorReponse(int code, String message) {
		Result model = new Result(code, message);
		return model;
	}

	public static Result errorReponse(String message) {
		return errorReponse(Result.JSON_FAILED_RESPONSE, message);
	}

	public static Result normalResponse(Object value) {
		Result model = new Result(value);
		return model;
	}

	public static Result normalResponse() {
		Result model = new Result();
		return model;
	}

	public boolean isSuccess() {
		return code >= JSON_SUCCESSED_RESPONSE;
	}

	public boolean isError() {
		return code <= JSON_FAILED_RESPONSE;
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
