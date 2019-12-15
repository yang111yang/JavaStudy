<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页查询</title>
</head>
<body>
	<table border="1px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${pi.list }" var="peo">
			<tr>
				<td>${peo.id}</td>
				<td>${peo.name}</td>
				<td>${peo.age}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="page?pageSize=${pi.pageSize }&pageNumber=${pi.pageNumber-1 }" <c:if test="${pi.pageNumber<=1}">onclick="javascript:return false"</c:if>>上一页</a>
	<a href="page?pageSize=${pi.pageSize }&pageNumber=${pi.pageNumber+1 }" <c:if test="${pi.pageNumber>=pi.total/pi.pageNumber}">onclick="javascript:return false"</c:if>>下一页</a>
</body>
</html>