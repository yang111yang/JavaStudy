<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${list}" var="peo">
			<tr>
				<td>${peo.id }</td>
				<td>${peo.name }</td>
				<td>${peo.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>