// var httpUrl ="http://www.hunanyoufu.com/sysdweb/ESB/UXUNDBF/UXUNJFYFRONT/";
//测试本地
// var httpUrl ="http://192.168.1.102:8080/sysdweb/ESB/UXUNDBF/UXUNJFYFRONT/";
//图书馆
// var httpUrl="http://10.0.167.75:8080/sysdweb/ESB/UXUNDBF/UXUNJFYFRONT/";
var httpUrl ="http://192.168.24.148/sysdweb/ESB/UXUNDBF/UXUNJFYFRONT/";
// var httpUrl ="http://www.hunanyoufu.com/sysdweb/ESB/UXUNDBF/UXUNJFYFRONT/";

// 用户提交受理维修
postListString = function () {
	var phone = $("#phone").val();
	var address=$("#address").val();
	if(address ==""){
		alert("请输入家庭住址");
		return true;
	}
    if(phone == ""){
        alert("请输入联系方式");
        return true;
    }
    // $.ajax({
    //     type : "POST",
    //     url : httpUrl+"addAccept",
    //     dataType : "json",
    //     data : JSON.stringify(GetJsonData(phone,address)),
    //     success : function(jsonResult) {
    //         alert(jsonResult.retshow.toString());
    //     },
    //     error : function(XMLHttpRequest, textStatus,
    //                      errorThrown) {
    //         alert(JSON.stringify(XMLHttpRequest) + "受理失败"
    //             + textStatus + "==" + errorThrown);
    //     }
    // });

    $.ajax({
        type : "POST",
        url : httpUrl+"addAccept",
        dataType : "json",
        data : JSON.stringify(GetJsonData(phone,address)),
        success : function(jsonResult) {
            alert(jsonResult.retshow.toString());
        },
        error : function(XMLHttpRequest, textStatus,
                         errorThrown) {
            alert(JSON.stringify(XMLHttpRequest) + "连接服务器失败啦"
                + textStatus + "==" + errorThrown);
        }
    });
}
//封装受理维修请求参数
GetJsonData = function (phone,address) {
	var json = {
			"accTime" : GetNowDataTime()+"",
			 "accPhone" : phone,
			"disType" : "3",
			"disState" : "1",
			"accAddress" : address,
			 "disStartTime" : "342",
			"disEndTime" : "234",
			"disStaff" : "234"
	};
	return json;
}
//**********************************************
/**
 * 用户登录，登录成查询用户开通截止日期
 */
selectUserInfo = function () {
	var phone = $("#user_phone").val();
	var userPsd=$("#user_psd").val();
	if(phone == ""){
		alert("请输入手机号");
		return true;
	}
	if(userPsd ==""){
		alert("请输入密码");
		return true;
	}
	$.ajax({
		async : false,
        type : "POST",
		url : httpUrl+"login",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(LoginGetJsonData(phone,userPsd)),

            success : function(jsonResult) {
			alert(JSON.stringify(jsonResult).toString());
			$("#userlogin_suc").html(jsonResult);
		},
		error : function(XMLHttpRequest, textStatus,
				errorThrown) {
			alert(JSON.stringify(XMLHttpRequest) + "111失败啦"
					+ textStatus + "==" + errorThrown);
			$("#userlogin_suc").html(XMLHttpRequest);
		}
	});
}
//封装登录请求请求参数
LoginGetJsonData = function (phone,userpsd) {
	var json = {
			"userPhone" : phone,
			"userPsd" : userpsd
	};
	return json;
}
	//意见反馈Http请求
feedbackHttpAjax = function () {
    var fb_phone = $("#fb_phone").val();
    var fb_content=$("#fb_content").val();
    if(fb_phone == ""){
        alert("请输入手机号");
        return true;
    }
    if(fb_content ==""){
        alert("请输反馈内容");
        return true;
    }

    // $.ajax({
    //     //提交数据的类型 POST GET
    //     type:"POST",
    //     //提交的网址
    //     url:httpUrl+"feedback",
    //     //提交的数据
		// data : JSON.stringify(FeedBackGetJsonData(fb_phone,fb_content)),
    //     //返回数据的格式
    //     datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
    //     //在请求之前调用的函数
    //     // beforeSend:function(){
    //     //     // showLoading();
    //     // 	// alert("beforeSend");
    //     // 	},
    //     //成功返回之后调用的函数
    //     success:function(jsonResult){
    //     	var data = JSON.stringify(jsonResult);
    //     	alert(data.retshow.toString());
    //         alert(data);
    //     },
    //     //调用执行后调用的函数
    //     // complete: function(XMLHttpRequest, textStatus){
    //     //     // alert(XMLHttpRequest.responseText);
    //     //     // alert(textStatus);
    //     //     //HideLoading();
    //     // },
    //     //调用出错执行的函数
    //     // error: function(){
    //     //     alert("err0r");
    //     //     //请求出错处理
    //     // },
    //     error : function(XMLHttpRequest, textStatus,
    //                          errorThrown) {
    //             alert(JSON.stringify(XMLHttpRequest) + "失败"
    //                 + textStatus + "==" + errorThrown);
    //         }
    // });

    $.ajax({
        type : "POST",
        url : httpUrl+"feedback",
        dataType : "json",
        data : JSON.stringify(FeedBackGetJsonData(fb_phone,fb_content)),
        success : function(jsonResult) {
            alert(jsonResult.retshow.toString());
        },
        error : function(XMLHttpRequest, textStatus,
                         errorThrown) {
            alert(JSON.stringify(XMLHttpRequest) + "失败"
                + textStatus + "==" + errorThrown);
        }
    });
    // $.ajax({
    //     async : true,
    //     type : "POST",
    //     url : httpUrl+"feedback",
    //     contentType : "application/json",
    //     dataType : "json",
    //     data : JSON.stringify(FeedBackGetJsonData(fb_phone,fb_content)),
    //     beforeSend: function(XMLHttpRequest){
    //         showLoading();
    //     },
    //     success : function(jsonResult) {
    //         alert(jsonResult);
    //         // alert(JSON.stringify(jsonResult).toString());
    //         // $.each(jsonResult.Products,function(i,n){
    //         // 	   alert(n.retcode);
    //         // 	})
    //     },
    //     error : function(XMLHttpRequest, textStatus,
    //                      errorThrown) {
    //         alert(JSON.stringify(XMLHttpRequest) + "连接服务器失败啦"
    //             + textStatus + "==" + errorThrown);
    //     }
    // });
    // $.post(httpUrl+"feedback",JSON.stringify(FeedBackGetJsonData(fb_phone,fb_content)),
    //     function(data,status){
    // 	if(status ==  "success"){
    //        alert(data.error);
		// }else{
    //         alert("数据: \n" + data + "\n状态: " + status);
    //     }
    //     });
}
//意见反馈封装请求参数
FeedBackGetJsonData = function (phone,content) {
    var json = {
        "FBPhone" : phone,
        "FBContent" : content,
		"FBTime":GetNowDataTime(),
		"FBId":"0003"
    };
    return json;
}
//获得当前系统时间
GetNowDataTime = function () {
    var datatime = new Date()
    var time = datatime.getFullYear() + "-" + datatime.getMonth() + "-"
        + datatime.getDay() + " " + datatime.getHours() + ":"
        + datatime.getMinutes() + ":" + datatime.getSeconds();
    return time;
}
showLoading=function(){
        $('body').append('<div id="loading_jz"><div class="ux-load" ></div>'+
            '<div class="ux-load-top"><div class="loader-inner line-spin-fade-loader">'+
            '<div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>'+
            '</div></div></div>');

    setTimeout(function(){$('#loading_jz').hide();},20000);
}
hideLoading=function(){
    $('#loading_jz').hide();
}
