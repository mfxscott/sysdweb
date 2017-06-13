package com.scott.net.server.impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.scott.net.message.*;
import com.scott.net.message.dispose.DisposeEntity;
import com.scott.net.message.dispose.ListAccDisposeEntity;
import org.jfree.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.scott.net.datadb.CommonSelect;
import com.scott.net.server.IJFYFrontService;
import com.scott.net.server.ObjectChangeJsonData;

@Service
@WebService(endpointInterface = "com.scott.net.server.IJFYFrontService")
public class JFYFrontService implements IJFYFrontService {
	@Override
	public String login(String ObjDate) {
		RspMsgEntity disrsp = new RspMsgEntity();
		JSONObject repmsg;
		try {
			repmsg = new JSONObject(ObjDate.toString());
			String userPhone= repmsg.getString("userPhone");
			String userPsd = repmsg.getString("userPsd");
			if(userPhone.equals("")){
				disrsp.setRetcode(CommonSelect.resultError);
				disrsp.setRetshow("手机号不能为空");
				return ObjectChangeJsonData.objectToJson(disrsp);
			}else if(userPsd.equals("")){
				disrsp.setRetcode(CommonSelect.resultError);
				disrsp.setRetshow("密码不能为空");
				return ObjectChangeJsonData.objectToJson(disrsp);
			}
			String result = CommonSelect.login(userPhone,userPsd);
			return result;
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 *根据手机号码查询用户所在地址
	 */
	@Override
	public String selectAddress(String ObjDate) {
		System.out.println(ObjDate+"===================");
		JSONObject repmsg;
		QurAddress qaddress = new QurAddress();
		try {
			repmsg = new JSONObject(ObjDate.toString());
			qaddress = CommonSelect.QurUserAddress(repmsg.getString("user_phone"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if(ObjDate == null || ObjDate.equals("")){
			return "查询数据失败，请输入手机号码";
		}
		try {
			return ObjectChangeJsonData.objectToJson(qaddress);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 查询用户
	 */
	@Override
	public String selectUser(String data) {
		Log.info("查询用户请求报文=======");
		System.out.println("用户查询数据===="+data);
		List<UserInfo> userinfoList = new ArrayList<UserInfo>();
		userinfoList = CommonSelect.QurUserInfo("1","1");
		try {
			String strdata = ObjectChangeJsonData.objectToJson(userinfoList);
			System.out.println("查询用户返回数据==="+strdata+"");
			return  strdata;
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加一条受理数据
	 */
	@Override
	public String addAccept(String data) {
		System.out.println("受理请求报文======="+data);
		RspMsgEntity disrsp = new RspMsgEntity();
		JSONObject	repmsg = null;
		String jsondata = null;
		try {
			repmsg = new JSONObject(data.toString());
			String result =  CommonSelect.insertInToDispose(repmsg);
			if(result.equals(CommonSelect.resultSuc)){
				disrsp.setError("0000");
				disrsp.setRetcode(CommonSelect.resultSuc);
				disrsp.setRetshow("添加成功，我们会尽快处理。");
				jsondata =  ObjectChangeJsonData.objectToJson(disrsp);
			}else{
				disrsp.setError("0004");
				disrsp.setRetcode(CommonSelect.resultError);
				disrsp.setRetshow("提交失败");
				jsondata  = ObjectChangeJsonData.objectToJson(disrsp);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("受理返回报文======="+jsondata);
		return jsondata;
	}
	/**
	 * 查询已受理维修记录
	 */
	@Override
	public String qurAccDispose(String data) {
		String strdata="";
		try {
			JSONObject jso = new JSONObject(data.toString());
			String state = jso.getString("state");
			String indexPage = jso.getString("index");
			System.out.println("受理列表请求报文======="+data);
			ListAccDisposeEntity lis = new ListAccDisposeEntity();
			lis = CommonSelect.qurAccDispose(state,indexPage);
			strdata = ObjectChangeJsonData.objectToJson(lis);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("受理列表返回报文======="+strdata);
		return strdata;
	}
	/**
	 * 查询员工数据
	 */
	@Override
	public String qurStaffInof(String data) {
		StaffInfoListEntity staff = new StaffInfoListEntity();
		staff = CommonSelect.QurStaffInfo();
		String strdata="";
		try {
			strdata = ObjectChangeJsonData.objectToJson(staff);
			System.out.println("职工列表返回报文======="+strdata);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strdata;
	}
	/**
	 * 修改受理问题进度及指派职员处理
	 */
	@Override
	public String qudateDispose(String data) {
		RspMsgEntity  rspmsg = new RspMsgEntity();
		String strdata="";
		JSONObject jso;
		try {
			jso = new JSONObject(data.toString());
			String disStartTime = jso.getString("disStartTime");
			String disStaff = jso.getString("disStaff");
			String disState = jso.getString("disState");
			String id = jso.getString("id");
			rspmsg = CommonSelect.updateDispValue("acc_record", disStartTime, disStaff, disState,id);
			strdata = ObjectChangeJsonData.objectToJson(rspmsg);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("受理维修进度指派======"+strdata);
		return strdata;
	}

	@Override
	public String feedback(String data) {
		RspMsgEntity disrsp = new RspMsgEntity();
		JSONObject repmsg;
		String jsondata="";
		System.out.println("反馈请求报文====="+data);
		try {
			repmsg = new JSONObject(data.toString());
			String fbPhone= repmsg.getString("FBPhone");
			String fbContent = repmsg.getString("FBContent");
			String fbtime=repmsg.getString("FBTime");
			String fbId = repmsg.getString("FBId");
//			System.out.println("请求报文====="+fbPhone+"=="+fbContent+"=="+fbtime+"=="+fbId);
//			if(fbPhone.equals("")){
//				disrsp.setError("0004");
//				disrsp.setRetcode(CommonSelect.resultError);
//				disrsp.setRetshow("联系方式不能为空");
//				return ObjectChangeJsonData.objectToJson(disrsp);
//			}else if(fbContent.equals("")){
//				disrsp.setError("0004");
//				disrsp.setRetcode(CommonSelect.resultError);
//				disrsp.setRetshow("反馈内容不能为空");
//				return ObjectChangeJsonData.objectToJson(disrsp);
//			}
			String  result  = CommonSelect.insertFeedback(fbPhone,fbContent,fbtime,fbId);
			if(result.equals(CommonSelect.resultSuc)){
				disrsp.setError("0000");
				disrsp.setRetcode(CommonSelect.resultSuc);
				disrsp.setRetshow("感谢您的反馈，我们会尽快处理。");
				jsondata =  ObjectChangeJsonData.objectToJson(disrsp);

			}else{
				disrsp.setError("0004");
				disrsp.setRetcode(CommonSelect.resultError);
				disrsp.setRetshow("反馈失败");
				jsondata  = ObjectChangeJsonData.objectToJson(disrsp);
			}
			System.out.println("反馈返回数据===="+jsondata);
			return jsondata;
		} catch (JSONException e) {
			System.out.println("===="+e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("===="+e.toString());
			e.printStackTrace();
		}
		return jsondata;
	}
}

