<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/login/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
	alert("12342")
	$("a").click(function(){
		$("img").attr("src","validcode?date="+new Date());
		return false;
	})
	
	$("form").submit(function(){
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var code = $("input[name='validcode']").val();
		f(username.length == 0){
			alert("用户名不能为空");
			return false;
		}
		f(password.length == 0){
			alert("密码不能为空");
			return false;
		}
		f(code.length == 0){
			alert("验证码不能为空");
			return false;
		}
	})
})
</script>
<style type="text/css">
	a{text-decoration:none}
</style>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="validcode" style="width:50px;height:17px"/><img src="validcode" ><a href="">看不清</a></td>
			</tr>
			<tr style="text-align: center;">
				<td><input type="submit" value="登录"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
	</form>
</body>
</html>