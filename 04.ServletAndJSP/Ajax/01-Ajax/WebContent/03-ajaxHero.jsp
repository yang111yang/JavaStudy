<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/ajaxUtil.js"></script>
<script type="text/javascript">
	function getData2(){
		//获取输入框的值
		var name = document.getElementById("name").value;
		getData("get","user","name="+name,function(a){
			//获取响应信息
			var result = a.responseText;
			//处理响应信息
			//alert(result);
			var obj = JSON.parse(result);
			var ta = document.getElementById("ta");
			ta.innerHTML="";
			var tr = ta.insertRow(0);
			var cell0 = tr.insertCell(0)
			cell0.innerHTML="编号";
			var cell1 = tr.insertCell(1);
			cell1.innerHTML="名称";
			var cell2 = tr.insertCell(2);
			cell2.innerHTML="描述";
			var tr = ta.insertRow(1);
			var cell0 = tr.insertCell(0);
			cell0.innerHTML=obj.uid;
			var cell1 = tr.insertCell(1);
			cell1.innerHTML=obj.uname;
			var cell2 = tr.insertCell(2);
			cell2.innerHTML=obj.des;
		});
	}
	
	
</script>
</head>
<body>
	<h3>英雄信息</h3>
	<hr>
	<input type="text" id="name" >
	<input type="button" value="搜索" onclick="getData2()" >
	<hr>
	<table id="ta" border="solid 1px">
	</table>
</body>
</html>