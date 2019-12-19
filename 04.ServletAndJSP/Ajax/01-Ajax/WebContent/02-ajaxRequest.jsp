<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajax</title>
<style type="text/css">
	#showDiv{
		width:200px;
		height:100px;
		border:solid 1px;
	}
</style>
<script type="text/javascript">
	function getReqData(){
		//创建ajax引擎对象
		var ajax;
		if (window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		}
		//复写onreadystatechange方法
		ajax.onreadystatechange = function(){
			//判断ajax状态码
			if (ajax.readyState == 4) {
				//判断响应码
				if (ajax.status == 200) {
					//获取响应信息
					var result = ajax.responseText;
					//处理响应信息
					alert(result);
				}
				
			}
			
		}
		//发送请求
		//get请求
		//ajax.open("get","ajax?name=张三&pwd=123");
		//ajax.send(null);
		//post请求
		ajax.open("post","ajax");
		ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		ajax.send("name=张三&pwd=123");
	}
</script>
</head>
<body>
	<h3>Ajax大峡谷</h3>
	<hr>
	<input type="button" id="btn" value="测试" onclick="getReqData()" >
	<div id="showDiv"></div>
</body>
</html>