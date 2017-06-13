/**
 * @{#} qurgoodsRsp.java Create on 2011年8月31日
 * 兑换商品查询--应答类--第二层节点
 * @author HuangWj
 * @version 1.0
 * Copyright @ 2009 - 2011 Shenzhen UXUN Information Technology CO., LTD.
 ********************************************************************************************
 *   Date      *      Developers ID      *      Modlog        *         Description         *
 ********************************************************************************************
 * 2011-08-31	          HuangWj                             	         v1.0 
 */
package com.scott.net.message;

import java.io.Serializable;

public class qurgoodsRsp implements Serializable {

	private static final long serialVersionUID = 2782585870478850036L;

	/** 响应码。说明：0000为正常，否则为错误 */
	private String retcode;
	/** 错误提示。说明：retcode为错误的时候出现错误提示 */
	private String retshow;

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

}
