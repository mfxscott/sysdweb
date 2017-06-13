/**
 * @{#} qurcusttransRsp.java Create on 2012年11月29日 
 * 客户经理（积分管理平台操做员）登录、注销登录接口--应答类
 * @author MaWenming
 * @version 1.0
 * Copyright @ 2009 - 2011 Shenzhen UXUN Information Technology CO., LTD.
 ********************************************************************************************
 *   Date      *      Developers ID      *      Modlog        *         Description         *
 ********************************************************************************************
 * 2012-11-29	          MaWenming                             	         v1.0 
 */
package com.scott.net.message.login;

import java.io.Serializable;

public class LoginRsp implements Serializable {

	private static final long serialVersionUID = -5559252940828667661L;

	/** 响应码。说明：0000为正常，否则为错误 */
	private String retcode;
	/** 错误提示。说明Retcode为错误的时候出现错误提示 */
	private String retshow;
	/** 客户经理名称 **/
	private String operatorName;
	/** 部门编号 **/
	private String departmentNo;
	/** 部门名称 **/
	private String departmentName;	
	/** 机构编号 **/
	private String institutionNo;
	/** 机构名称 **/
	private String institutionName;
	/** 网点ids 注：银行的机构编号和网点编号一致，一个网点编号可能对应多个网点id **/
	private String storeIds;
	
	
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
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getInstitutionNo() {
		return institutionNo;
	}
	public void setInstitutionNo(String institutionNo) {
		this.institutionNo = institutionNo;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getStoreIds() {
		return storeIds;
	}
	public void setStoreIds(String storeIds) {
		this.storeIds = storeIds;
	}
	
}
