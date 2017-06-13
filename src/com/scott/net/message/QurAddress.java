package com.scott.net.message;

import java.io.Serializable;

/**
 * 用户地址
 * @author scott
 */
public class QurAddress implements Serializable {
   private String user_name;
   private String user_psd;
   private String user_phone;
   private String user_address;
   

public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public String getUser_psd() {
	return user_psd;
}

public void setUser_psd(String user_psd) {
	this.user_psd = user_psd;
}

public String getUser_phone() {
	return user_phone;
}

public void setUser_phone(String user_phone) {
	this.user_phone = user_phone;
}

public String getUser_address() {
	return user_address;
}

public void setUser_address(String user_address) {
	this.user_address = user_address;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
