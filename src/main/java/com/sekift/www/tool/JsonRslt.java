package com.sekift.www.tool;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: yinzhang.lu
 * @date: 2020/10/20 11:15
 * @description: 标准的JSON对象输出格式
 **/
@ApiModel(description="后台向前台返回的JSON对象")
public class JsonRslt implements java.io.Serializable {

	@ApiModelProperty(value = "请求成功与否，为true表示成功，false表示失败，失败原因使用code和msg说明",
			required = true, readOnly = false, example = "true", position = 1)
	private boolean success = false;

	@ApiModelProperty(value = "返回状态编码，成功时返回0，其他值对应具体失败情况",
			required = true, readOnly = false, example = "0", position = 2)
	private Integer code = 0;

	@ApiModelProperty(value = "请求失败时具体原因说明",
			required = true, readOnly = false, example = "", position = 3)
	private String msg = "";

	@ApiModelProperty(value = "请求返回的具体数据",
			required = false, readOnly = false, example = "{\"key\":\"value\"}", position = 4)
	private Object data = null;

	@ApiModelProperty(value = "系统响应时的10位时间戳",
			required = true, readOnly = false, example = "1600239086", position = 5)
	private Long timestamp = 0L;

	public static JsonRslt putSuccess(Object data) {
		JsonRslt rslt = new JsonRslt();
		rslt.setSuccess(true);
		rslt.setTimestamp(getCurrentTimestamp());
		rslt.setData(data);
		return rslt;
	}

	public static JsonRslt putSuccessMsg(String msg) {
		JsonRslt rslt = new JsonRslt();
		rslt.setSuccess(true);
		rslt.setTimestamp(getCurrentTimestamp());
		rslt.setMsg(msg);
		return rslt;
	}

	public static JsonRslt putError(Object data) {
		JsonRslt rslt = new JsonRslt();
		rslt.setTimestamp(getCurrentTimestamp());
		if (data != null && data instanceof String) {
			rslt.setMsg((String)data);
		} else {
			rslt.setData(data);
		}
		return rslt;
	}

	public static JsonRslt putErrorCode(Integer code, String msg) {
		JsonRslt rslt = new JsonRslt();
		rslt.setTimestamp(getCurrentTimestamp());
		rslt.code = code;
		if (msg != null) {
			rslt.msg = msg;
		}
		return rslt;
	}

	/**
	 * 需求是10位数的时间戳，故除以1000
	 * @return
	 */
	private static Long getCurrentTimestamp(){
		return System.currentTimeMillis()/1000;
	}

	public static JsonRslt putErrorCode(Integer code) {
		return putErrorCode(code, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(final Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Object getData() {
		return data;
	}

	public JsonRslt setData(Object data) {
		this.data = data;
		return this;
	}
}
