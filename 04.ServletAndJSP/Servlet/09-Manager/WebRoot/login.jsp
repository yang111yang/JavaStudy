<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


	<div class="logintop">    
   		<span>欢迎登录后台管理界面平台</span>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
     <!-- 使用EL和JSTL编写提示语 -->
    <c:choose>
    	<c:when test="${flag==0}">
    		<div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">用户名或密码错误</span></div>
    	</c:when>
    	<c:when test="${flag==1}">
    		<div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">密码修改成功</span></div>
    	</c:when>
    	<c:when test="${flag==2}">
    		<div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">注册成功</span></div>
    	</c:when>
    	<c:when test="${flag==3}">
    		<div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">注册失败</span></div>
    	</c:when>
    </c:choose>
    <%-- <%
    	//登录失败提示语
    	Object obj = request.getAttribute("flag");
    	if(obj != null){
     %>
    <div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">用户名或密码错误</span></div>
    <%} %>  
    <%
    	//密码修改成功提示语
    	Object pwd = session.getAttribute("pwd");
    	if(pwd != null){
     %>
    <div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">密码修改成功</span></div>
    <%} %>
    <%
    	//注册成功提示语
    	Object reg = session.getAttribute("reg");
    	if(reg != null){
     %>
    <div style="text-align: center"><span style="font-size:20px;color:darkred;font-weight:blod">注册成功</span></div>
    <%} %> --%>
    <div class="loginbox loginbox1">
    <form action="user" method="post">
	    	<input type="hidden" name="oper" value="login" />
	    <ul>
		    <li><input name="uname" type="text" class="loginuser" placeholder="用户名"/></li>
		    <li><input name="pwd" type="password" class="loginpwd" placeholder="密码"/></li>
		    <li class="yzm">
		    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite> 
		    </li>
		    <li><input name="" type="submit" class="loginbtn" value="登录"  /><label><a href="user/reg.jsp">注册</a></label><label><a href="#">忘记密码？</a></label></li>
	    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    <div class="loginbm">版权所有  刘建阳  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途，QQ:123456789</div>
	
    
</body>

</html>

