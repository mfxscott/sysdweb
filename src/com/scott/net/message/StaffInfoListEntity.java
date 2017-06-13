package com.scott.net.message;

import java.util.List;

/**
 * 员工返回数据列
 * @author scott
 *
 */
public class StaffInfoListEntity {
	/** 响应码。说明：0000为正常，否则为错误 */
	private String retcode;
	/** 错误提示。说明Retcode为错误的时候出现错误提示 */
	private String retshow;
	private List<StaffInfoEntity> listStaff;
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
	public List<StaffInfoEntity> getListStaff() {
		return listStaff;
	}
	public void setListStaff(List<StaffInfoEntity> listStaff) {
		this.listStaff = listStaff;
	}
	
	
}
