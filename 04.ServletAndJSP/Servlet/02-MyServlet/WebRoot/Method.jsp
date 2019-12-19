<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/ms/req" method="post">
	   	用户名：<input type="text" name="username" value=""/><br/>
	   	密码：<input type="password" name="pwd" value=""/><br/>
	   	爱好：<br>
	   	<input type="checkbox" name="fav" value="1"/>唱歌<br/>
	   	<input type="checkbox" name="fav" value="2"/>跳舞<br/>
	   	<input type="checkbox" name="fav" value="3"/>长跑<br/>
	   	<input type="submit" name="" value="登录"/>
    </form>
</body>
</html>