package com.scott.net.message;

/**
 * 用户信息表
 * @author scott
 *
 */
public class UserInfo {
        private String usermane;
        private String userpsd;
        private String userage;
        private String  userphone;
        private String  address;
        private String user_starttime;
        private String user_endtime;
        private String user_type;
        
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getUsermane() {
			return usermane;
		}
		public void setUsermane(String usermane) {
			this.usermane = usermane;
		}
		public String getUserpsd() {
			return userpsd;
		}
		public void setUserpsd(String userpsd) {
			this.userpsd = userpsd;
		}
		public String getUserage() {
			return userage;
		}
		public void setUserage(String userage) {
			this.userage = userage;
		}
		public String getUserphone() {
			return userphone;
		}
		public void setUserphone(String userphone) {
			this.userphone = userphone;
		}
		public String getUser_starttime() {
			return user_starttime;
		}
		public void setUser_starttime(String user_starttime) {
			this.user_starttime = user_starttime;
		}
		public String getUser_endtime() {
			return user_endtime;
		}
		public void setUser_endtime(String user_endtime) {
			this.user_endtime = user_endtime;
		}
		public String getUser_type() {
			return user_type;
		}
		public void setUser_type(String user_type) {
			this.user_type = user_type;
		}
        
}
