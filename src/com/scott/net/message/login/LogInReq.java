/**
 * @{#} LogInReq.java Create on 2012年11月29日 
 * 客户经理（积分管理平台操做员）登录、注销登录接口--请求类
 * @author MaWenming
 * @version 1.0
 * Copyright @ 2009 - 2011 Shenzhen UXUN Information Technology CO., LTD.
 ********************************************************************************************
 *   Date      *      Developers ID      *      Modlog        *         Description         *
 ********************************************************************************************
 * 2012-11-29	         MaWenming                             	         v1.0 
 */
package com.scott.net.message.login;

import java.io.Serializable;

public class LogInReq implements Serializable {
	private static final long serialVersionUID = -6349125859243367252L;
	
	private String operNo;      //操作员编号，即登录名
	private String password;    //操作员密码
	private String operFlag;    //操作标识 0--注销登录  1--登录
	
	public String getOperNo() {
		return operNo;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOperFlag() {
		return operFlag;
	}
	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}
	
}
