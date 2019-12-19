<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"src="js/jQuery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("form").submit(function(){
			if ($(":text:eq(0)").val() == "" || $(":text:eq(1)").val() == "" || $(":text:eq(2)").val() == "") {
				alert("请添加完整信息");
				return false;
			}
		});
		
		
	});
</script>
</head>
<body>
	<form action="add" method="post">
		<table>
			<tr>
				<td colspan="2" align="center">花卉信息</td>
			</tr>
			<tr>
				<td>花卉名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>花卉价格：</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>原产地：</td>
				<td><input type="text" name="production" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="提交" /><input type="reset" name="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>