/**
 * @{#} LoginReqMsg.java Create on 2012年11月29日
 * 客户经理（积分管理平台操做员）登录、注销登录接口--请求类的消息体
 * @author MaWenming
 * @version 1.0
 * Copyright @ 2009 - 2011 Shenzhen UXUN Information Technology CO., LTD.
 ********************************************************************************************
 *   Date      *      Developers ID      *      Modlog        *         Description         *
 ********************************************************************************************
 * 2012-11-29	        MaWenming                             	         v1.0 
 */
package com.scott.net.message.login;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.scott.net.message.head;

@XmlRootElement
public class LoginReqMsg implements Serializable {

	private static final long serialVersionUID = 2244540424188522253L;

	/** 报文头 */
	private head msghead;
	/** 报文体 */
	private LogInReq msgreq;
	
	public head getMsghead() {
		return msghead;
	}
	public void setMsghead(head msghead) {
		this.msghead = msghead;
	}
	public LogInReq getMsgreq() {
		return msgreq;
	}
	public void setMsgreq(LogInReq msgreq) {
		this.msgreq = msgreq;
	}

}
