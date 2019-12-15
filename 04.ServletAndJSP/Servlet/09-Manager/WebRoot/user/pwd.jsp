<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#pwd").submit(function(){
				//校验密码格式
				if($("#newPwd").val() == ""){
					alert("新密码为空");
					return false;
				} else if($("#cfPwd").val() == ""){
					alert("确认密码为空");
					return false;
				} else if($("#newPwd").val() != $("#cfPwd").val()){
					alert("两次密码不一致");
					return false;
				} else {
					return true;
				}
			})
		})
		
	</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
    <form action="user"	method="post" id="pwd" target="_top">
    	<input name="oper" type="hidden" value="pwd" />
	    <ul class="forminfo">
		    <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput" /><i></i></li>
		    <li><label>确认密码</label><input name="" id="cfPwd" type="text" class="dfinput" /><i></i></li>
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>


</body>

</html>

