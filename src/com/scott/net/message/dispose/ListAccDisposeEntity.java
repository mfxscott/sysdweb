package com.scott.net.message.dispose;

import java.util.List;

public class ListAccDisposeEntity {
	/** 响应码。说明：0000为正常，否则为错误 */
	private String retcode;
	/** 错误提示。说明Retcode为错误的时候出现错误提示 */
	private String retshow;
	private String  error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private List<DisposeEntity> dispList;
	
	public List<DisposeEntity> getDispList() {
		return dispList;
	}
	public void setDispList(List<DisposeEntity> dispList) {
		this.dispList = dispList;
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

