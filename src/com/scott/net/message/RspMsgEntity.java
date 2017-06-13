package com.scott.net.message;


/**
 * 请求返回 响应信息
 * @author scott
 *
 */
public class RspMsgEntity {
	/** 响应码。说明：0000为正常，否则为错误 */
	private String retcode;
	/** 错误提示。说明Retcode为错误的时候出现错误提示 */
	private String retshow;
	private String error;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getRetshow() {
		return retshow;
	}
	public void setRetshow(String retshow) {
		this.retshow = retshow;
	}
	
}
