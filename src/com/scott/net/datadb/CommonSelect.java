package com.scott.net.datadb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scott.net.message.dispose.DisposeEntity;
import com.scott.net.message.dispose.ListAccDisposeEntity;
import com.scott.net.server.ObjectChangeJsonData;
import org.jfree.util.Log;
import org.json.JSONException;

import com.scott.net.message.QurAddress;
import com.scott.net.message.RspMsgEntity;
import com.scott.net.message.StaffInfoEntity;
import com.scott.net.message.StaffInfoListEntity;
import com.scott.net.message.UserInfo;
import org.json.JSONObject;

/**
 * 公共数据库查询
 */
public class CommonSelect {
	public static String  resultSuc = "0000";//返回数据成功
	public static String  resultError = "0004";//返回数据错误
	public static String  resultSqlError = "0010";//查询数据库异常
	private  static String sql = null;
	private    static   HelpDB dbh= null;
	private static ResultSet ret= null;
	public static String testConectiondb(){
		String uid = "";
		sql = "select * from staff_user_tb";
		dbh = new HelpDB(sql);
		try {
			ret = dbh.pst.executeQuery();
			while (ret.next()){
				uid = ret.getString(1);
				               String uname = ret.getString(2);
				               String fname = ret.getString(3);
				               System.out.println(uid+ "\t"+uname+ "\t"+fname);
			}
			ret.close();
			dbh.close();
		} catch (SQLException e) {
			return resultSqlError;
		}
		return uid+"";
	}
	/**
	 * 登录
	 * @param username
	 * @return
	 */
	public static String login(String username,String psd){
		RspMsgEntity disrsp = new RspMsgEntity();
		String userpsd = "";
		sql = "select user_psd from user where user_name ='"+username+"'";
		
//		sql = "select user_psd from user where user_name = 'ma'";
		System.out.println("sql========"+sql);
		dbh = new HelpDB(sql);
		try {
			ret = dbh.pst.executeQuery();
			while (ret.next()){
				userpsd = ret.getString(1);
//				              uid += ret.getString(2);
//				              uid += ret.getString(3);
			}
			if(userpsd.equals(psd)){
				disrsp.setRetcode(resultSuc);
				disrsp.setRetshow("成功");
			}else{
				disrsp.setRetcode(resultError);
				disrsp.setRetshow("密码错误");
			}
			ret.close();
			dbh.close();
		} catch (SQLException e) {
			disrsp.setError(e.toString());
			disrsp.setRetcode(resultSqlError);
			disrsp.setRetshow("查询数据库失败");
		}
		try {
			return  ObjectChangeJsonData.objectToJson(disrsp);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 根据手机号号码查询用户住址
	 * @param phone
	 * @return
	 */
	public static QurAddress QurUserAddress(String phone){
		QurAddress  qaddress = new QurAddress();
		String uid = "";
		sql = "select user_address from user where user_phone='"+phone+"'";
		dbh = new HelpDB(sql);
		try {
			ret = dbh.pst.executeQuery();
			while (ret.next()){
				uid = ret.getString(1);
				qaddress.setUser_address(uid);
				System.out.println(qaddress.getUser_address()+"==数据库查询===");
			}
			ret.close();
			dbh.close();
		} catch (SQLException e) {
			return null;
		}
		return qaddress;
	}
	/**
	 * 查询用户信息
	 * @param index
	 * @return
	 */
	public static List<UserInfo> QurUserInfo(String index, String page){
		List<UserInfo> userinfolist = new ArrayList<UserInfo>();
		UserInfo userinfo = null;
		sql = "select * from user";
		dbh = new HelpDB(sql);
		try {
			ret = dbh.pst.executeQuery();
			int pageint = 1;
			while (ret.next()){
				userinfo = new UserInfo();
				String name = ret.getString(2);
				String psd = ret.getString(3);
				String age = ret.getString(4);
				String phone = ret.getString(5);
				String address = ret.getString(6);
				String starttime = ret.getString(7);
				String endtime = ret.getString(8);
				userinfo.setUsermane(name);
				userinfo.setUserpsd(psd);
				userinfo.setUserage(age);
				userinfo.setUserphone(phone);
				userinfo.setAddress(address);
				userinfo.setUser_starttime(starttime);
				userinfo.setUser_endtime(endtime);
				System.out.println(userinfo.getUsermane()+"==数据库查询===");
				if(pageint > Integer.parseInt(page) ){
					break;
				}else{
					pageint ++;
					userinfolist.add(userinfo);
				}
			}
			ret.close();
			dbh.close();
		} catch (SQLException e) {
			return null;
		}
		return userinfolist;
	}
	/**
	 * 保存一条处理维修数据
	 * @return
	 */
	public static String insertInToDispose(JSONObject jsonObject){
		String result="0000";
		try {
			//生产需要数据库名称.表名
			String sql = null;

			try {
				String phone = URLDecoder.decode((String) jsonObject.get("accPhone"), "UTF-8");
				String address = URLDecoder.decode((String) jsonObject.get("accAddress"), "UTF-8");
				sql = "INSERT INTO sysddb.acc_record (acc_time, dispose_starttime, dispose_endtime, acc_phone, acc_address, dispose_staff, dispose_type, dispose_state) " +
                        "VALUES ('"+jsonObject.get("accTime")+"', '"+jsonObject.get("disStartTime")+"', '"+jsonObject.get("disEndTime")+"', '"+phone+"', '"+address+"', '"+jsonObject.get("disStaff")+"', '"+jsonObject.get("disType")+"', '"+jsonObject.get("disState")+"')";
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
//			String sql = "INSERT INTO acc_record (acc_time, dispose_starttime, dispose_endtime, acc_phone, acc_address, dispose_staff, dispose_type, dispose_state) VALUES ('21231', '123', '123', '123', '123', '123', '123', '123')";
			dbh = new HelpDB(sql);
			dbh.pst.execute(sql);
			dbh.close();
			result = resultSuc;
		} catch (SQLException e) {
			result = resultSqlError;
			e.printStackTrace();
			return result;
		}
		return result;
	}
	/**
	 * 指派受理问题处理人和状态
	 * @return
	 */
	public static RspMsgEntity updateDispValue(String tableName,String starttime,String staffname,String state,String id){
		RspMsgEntity disrsp = new RspMsgEntity();
		try {
			String sql = "update "+tableName+" set  dispose_starttime='"+starttime+"',dispose_staff='"+staffname+"',dispose_state='"+state +"' where id='"+id+"'";
			System.out.println("修改维修进度sql====="+sql);
			dbh = new HelpDB(sql);
			dbh.pst.execute(sql);
			dbh.close();
		} catch (SQLException e) {
			disrsp.setError(e.toString());
			disrsp.setRetcode(resultSqlError);
			disrsp.setRetshow("查询数据库失败");
			return disrsp;
		}
		disrsp.setError(resultSuc+"");
		disrsp.setRetcode(resultSuc);
		disrsp.setRetshow("保存成功");
		return disrsp;
	}
	/**
	 * 查询所有已受理维修记录
	 * @param state   受理状态
	 * @param indexpage  当前页号
	 * @return
	 */
	public static ListAccDisposeEntity qurAccDispose(String state, String indexpage){
		ListAccDisposeEntity lis = new ListAccDisposeEntity();
		List<DisposeEntity> userinfolist = new ArrayList<DisposeEntity>();
		DisposeEntity disposee = null;

		if(state.equals("4")){
			sql = "select * from acc_record";
		}else{
			int index = Integer.parseInt(indexpage);
			if(index == 1){
				sql = "select * from sysddb.acc_record where dispose_state="+state+" order by id desc limit 0,10";
			}else{
				sql = "select * from sysddb.acc_record where dispose_state="+state+" order by id desc limit "+((index-1)*10)+","+(index*10);
			}
		}
		System.out.println("查询语句===="+sql);
		dbh = new HelpDB(sql);
		try {
			ret = dbh.pst.executeQuery();
			while (ret.next()){
				disposee = new DisposeEntity();
				disposee.setId(ret.getString(1));
				disposee.setAccTime(ret.getString(2));
				disposee.setDisStartTime(ret.getString(3));
				disposee.setDisEndTime(ret.getString(4));
				disposee.setAccPhone(ret.getString(5));
				disposee.setAccAddress(ret.getString(6));
				disposee.setDisStaff(ret.getString(7));
				disposee.setDisType(ret.getString(8));
				disposee.setDisState(ret.getString(9));
				userinfolist.add(disposee);
			}
			if(userinfolist.size()>0){
				lis.setRetcode(resultSuc);
				lis.setRetshow("查询成功");
			}else{
				lis.setRetcode(resultError);
				lis.setRetshow("未查询相关数据");
			}
			lis.setError(resultSuc+"");
			ret.close();
			dbh.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
			lis.setError(e.toString()+"");
			lis.setRetcode(resultSqlError);
			lis.setRetshow("查询数据异常");
		}
		lis.setDispList(userinfolist);
		return lis;
	}
	/**
	 * 查询员工用户信息
	 * @param
	 * @return
	 */
	public static StaffInfoListEntity QurStaffInfo(){
		StaffInfoListEntity staff = new StaffInfoListEntity();
		List<StaffInfoEntity> userinfolist = new ArrayList<StaffInfoEntity>();
		StaffInfoEntity staffinfo ;
		sql = "select * from tb_staff";
		dbh = new HelpDB(sql);
		try {
			ret = dbh.pst.executeQuery();
			while (ret.next()){
				staffinfo =new StaffInfoEntity();
				staffinfo.setStaffName(ret.getString(2));
				staffinfo.setStaffPhone(ret.getString(3));
				staffinfo.setStaffAge(ret.getString(4));
				staffinfo.setStaffEntryTime(ret.getString(5));
				staffinfo.setStaffId(ret.getString(6));
				staffinfo.setStaffIdCard(ret.getString(7));
				staffinfo.setStaffAddress(ret.getString(8));
				userinfolist.add(staffinfo);
			}
			if(userinfolist.size() >0){
			staff.setRetshow("查询成功");
			staff.setRetcode(resultSuc);
			}
			else{
				staff.setRetshow("未查询到相关数据");
				staff.setRetcode(resultError);
			}
			
			ret.close();
			dbh.close();
		} catch (SQLException e) {
			staff.setRetshow("查询数据库异常");
			staff.setRetcode(resultSqlError);
		}
		staff.setListStaff(userinfolist);
		return staff;
	}
	/**
	 * 保存已经反馈数据
	 * @return
	 */
	public static String insertFeedback(String fbphone,String fbcontent,String time,String fbId){
		try {
			LogUtil.LogDebug("请求参数==="+fbcontent);
			String fbphoneu = URLDecoder.decode(fbphone, "UTF-8");
			String fbcontentu = URLDecoder.decode(fbcontent, "UTF-8");
			//生产需要 数据库名称
//			String sql = "INSERT INTO feedback (fb_phone, fb_content, fb_time, fb_userid) VALUES ('"+fbphone+"','"+fbcontent+"','"+time+"','"+fbId+"')";
			String sql = "INSERT INTO sysddb.feedback (fb_phone, fb_content, fb_time, fb_userid) VALUES ('"+fbphoneu+"','"+fbcontentu+"','"+time+"','"+fbId+"')";

			dbh = new HelpDB(sql);
			dbh.pst.execute(sql);
			dbh.close();
			System.out.println("意见反馈111======"+sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("意见反馈222======"+e.toString());
			return resultSqlError;
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "0000";
	}
}
