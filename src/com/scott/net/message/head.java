package com.scott.net.message;

import java.io.Serializable;

public class head implements Serializable {

	private static final long serialVersionUID = -958683373779516912L;

	/* 版本号 */private String version;
	/* 渠道类型 */private String tranchannel;
	/* 前端时间 */private String trandatetime;
	/* 认证码 */private String authcode;
	/* 请求流水号 */private String reqsn;
	/* 后台服务方法 */private String servicename;
	/* 设备号 */private String devno;
	/* 签名 */private String signData;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTranchannel() {
		return tranchannel;
	}

	public void setTranchannel(String tranchannel) {
		this.tranchannel = tranchannel;
	}

	public String getTrandatetime() {
		//这里提高下兼容性，如果trandatetime 为空，则赋值本系统时间、如果不是
		//yyyymmdd hh:mm:ss  时间格式，则做格式化
		return trandatetime;
	}

	public void setTrandatetime(String trandatetime) {
		this.trandatetime = trandatetime;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getReqsn() {
		return reqsn;
	}

	public void setReqsn(String reqsn) {
		this.reqsn = reqsn;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getDevno() {
		return devno;
	}

	public void setDevno(String devno) {
		this.devno = devno;
	}

	public String getSignData() {
		return signData;
	}

	public void setSignData(String signData) {
		this.signData = signData;
	}
	
	

}
