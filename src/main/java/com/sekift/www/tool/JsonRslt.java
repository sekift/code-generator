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

	@ApiModelProperty(value = "请求成功与否，为true表示成功，false表示失败，失败原因使用status和message说明",
			required = true, accessMode = ApiModelProperty.AccessMode.READ_WRITE, example = "true", position = 1)
	private boolean success = false;

	@ApiModelProperty(value = "返回状态编码，成功时返回0，其他值对应具体失败情况",
			required = true, accessMode = ApiModelProperty.AccessMode.READ_WRITE, example = "00000", position = 2)
	private String code = "";

	@ApiModelProperty(value = "请求失败时具体原因说明",
			required = true, accessMode = ApiModelProperty.AccessMode.READ_WRITE, example = "成功。", position = 3)
	private String message = "";

	@ApiModelProperty(value = "请求返回的具体数据",
			required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE, example = "{\"key\":\"value\"}", position = 4)
	private Object data = null;

	@ApiModelProperty(value = "系统响应时的10位时间戳",
			required = true, accessMode = ApiModelProperty.AccessMode.READ_WRITE, example = "1600239086", position = 5)
	private Long timestamp = 0L;

	public static JsonRslt putSuccessMessage(String message) {
		return putSuccessMessageAndData(message, null);
	}

	public static JsonRslt putSuccess(Object data) {
		return putSuccessMessageAndData(null, data);
	}

	public static JsonRslt putSuccessMessageAndData(String message, Object data) {
		JsonRslt rslt = new JsonRslt();
		rslt.setSuccess(true);
		rslt.setCode(ErrorCodeEnum.SUCCESS.getCode());
		rslt.setMessage(ErrorCodeEnum.SUCCESS.getMessage() + "。" + (message==null?"":message));
		rslt.setData(data);
		rslt.setTimestamp(getCurrentTimestamp());
		return rslt;
	}

	public static JsonRslt putError(Object data) {
		JsonRslt rslt = new JsonRslt();
		rslt.setTimestamp(getCurrentTimestamp());
		if (data != null && data instanceof String) {
			rslt.setMessage((String)data);
		} else {
			rslt.setData(data);
		}
		return rslt;
	}

	public static JsonRslt putErrorCode(String code) {
		return putErrorCode(code, null);
	}

	public static JsonRslt putErrorCode(String code, String message) {
		JsonRslt rslt = new JsonRslt();
		rslt.setCode(code);
		message = ErrorCodeEnum.getMessageByCode(code) + "。" + (message==null?"":message);
		if (message != null) {
			rslt.setMessage(message);
		}
		rslt.setTimestamp(getCurrentTimestamp());
		return rslt;
	}

	/**
	 * 需求是10位数的时间戳，故除以1000
	 * @return
	 */
	private static Long getCurrentTimestamp(){
		return System.currentTimeMillis()/1000;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	@Override
	public String toString() {
		return "JsonRslt{" +
				"success=" + success +
				", code='" + code + '\'' +
				", message='" + message + '\'' +
				", data=" + data +
				", timestamp=" + timestamp +
				'}';
	}
}
