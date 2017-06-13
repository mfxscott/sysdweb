/**
 * @{#} IJFYFrontService.java Create on 2011年8月6日
 * 积分前置接口
 * @author HuangWj
 * @version 1.5
 * Copyright @ 2009 - 2011 Shenzhen UXUN Information Technology CO., LTD.
 ********************************************************************************************
 *   Date      *      Developers ID      *      Modlog        *         Description         *
 ********************************************************************************************
 * 2011-08-31	          HuangWj                             	         v1.1 
 * 2011-09-27             LeiYj                增加积分消费接口                                      v1.3
 * 2011-09-29             HuangWj              增加积分抽奖相关接口                            v1.4
 * 2011-11-24             HuangWj              增加积分兑换接口                                      v1.5
 * 2011-11-26             HuangWj              增加待发送短信查询接口                       v1.6
 */
package com.scott.net.server;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
@WebService
@Path("/UXUNJFYFRONT")
public interface IJFYFrontService {
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/login")
	public String login(@WebParam(name = "uxunmsg") String data);
	
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/address")
	public String selectAddress(@WebParam(name = "uxunmsg") String phone);
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/qurUser")
	public String selectUser(@WebParam(name = "uxunmsg") String data);
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/addAccept")
	public String addAccept(@WebParam(name = "uxunmsg") String data);
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/qurAccDispose")
	public String qurAccDispose(@WebParam(name = "uxunmsg") String data);
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/qurStaffInfo")
	public String qurStaffInof(@WebParam(name = "uxunmsg") String data);
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/qudateDispose")
	public String qudateDispose(@WebParam(name = "uxunmsg") String data);
	@WebResult(name = "uxunmsg")
	@POST
	@Path("/feedback")
	public String feedback(@WebParam(name = "uxunmsg") String data);
	
}



