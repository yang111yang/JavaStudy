function getData(method,url,data,deal200,acsyn){
	var ajax = getAjax();
	//复写onreadystatechange方法
	ajax.onreadystatechange = function(){
		//判断ajax状态码
		if (ajax.readyState == 4) {
			//判断响应状态码
			if (ajax.status == 200) {
				deal200(ajax);
			}
		}
	}
	
	//发送请求
	if (method == "get") {
		ajax.open("get",url+"?"+data,acsyn);
		ajax.send(null);
	} else if (method == "post") {
		ajax.open("post",url,acsyn);
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		ajax.send(data);
	}
}

function getAjax(){
	//创建ajax引擎对象
	var ajax;
	//初始化ajax引擎对象
	if (window.XMLHttpRequest) { // 火狐
		ajax = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		ajax = new ActiveXObject("Msxml2.XMLHTTP");
	}
	return ajax;
}