<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script src="js/cloud.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			$("#panel_reg").panel('move',{
			    left:450,
			    top:170
			}); 
			$("#ff").submit(function(){
				if($("#uname").val() == ""){
					alert("用户名为空");
					return false;
				} else if($("#pwd").val() == ""){
					alert("密码为空");
					return false;
				} else {
					return true;
				}
			})
		})
	</script>
</head>
<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
	<div style="margin:20px 0;"></div>
	<div id="panel_reg" class="easyui-panel" title="注册" style="width:100%;max-width:400px;padding:30px 60px;background-color: rgba(0,0,0,0.1);border:0px solid;"
			data-options="style:{position:'absolute'}">
		<form id="ff" action="user" method="post">
			<input	type="hidden" name="oper" value="reg"	>
			<div style="margin-bottom:20px">
				<input id="uname" class="easyui-textbox" name="uname" style="width:100%" data-options="label:'用户名:',required:true" missingMessage="用户名必填">
			</div>
			<div style="margin-bottom:20px">
				<input id="pwd" class="easyui-textbox" name="pwd" style="width:100%" data-options="label:'密码:',required:true" missingMessage="密码必填">
			</div>
			<div style="margin-bottom:20px">
				<label>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				男<input type="radio" name="sex" value="1" checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;
				女<input type="radio" name="sex" value="0"/>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="age" style="width:100%" data-options="label:'年龄:'" >
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-datebox" name="birth" style="width:100%" data-options="label:'出生年月:'">
			</div>
			<div style="margin-bottom:20px;text-align:center">
				<input name="" type="submit" value="注册" 
				style="width:80px;height:30px;background-image:url(images/btnbg.png);color:white" >
			</div>
		</form>
	</div>
</body>
</html>