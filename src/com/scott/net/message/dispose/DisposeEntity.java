package com.scott.net.message.dispose;

/**
 * 维护处理实体类
 * @author scott
 *
 */
public class DisposeEntity {
	private String id;
	private String accTime;  //受理时间
	private String disStartTime;//安排职员处理时间
	private String disEndTime;//职员处理完毕时间
	private String accPhone;//用户联系方式
	private String disStaff;//职员名称
	private String disType;//处理事项（电 水）
	private String disState;//处理进度
	private String accAddress;//用户家庭住址

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccTime() {
		return accTime;
	}

	public void setAccTime(String accTime) {
		this.accTime = accTime;
	}
	public String getDisStartTime() {
		return disStartTime;
	}
	public void setDisStartTime(String disStartTime) {
		this.disStartTime = disStartTime;
	}
	public String getDisEndTime() {
		return disEndTime;
	}
	public void setDisEndTime(String disEndTime) {
		this.disEndTime = disEndTime;
	}
	public String getAccPhone() {
		return accPhone;
	}
	public void setAccPhone(String accPhone) {
		this.accPhone = accPhone;
	}
	public String getDisStaff() {
		return disStaff;
	}
	public void setDisStaff(String disStaff) {
		this.disStaff = disStaff;
	}
	public String getDisType() {
		return disType;
	}
	public void setDisType(String disType) {
		this.disType = disType;
	}
	public String getDisState() {
		return disState;
	}
	public void setDisState(String disState) {
		this.disState = disState;
	}
	public String getAccAddress() {
		return accAddress;
	}
	public void setAccAddress(String accAddress) {
		this.accAddress = accAddress;
	}

}
