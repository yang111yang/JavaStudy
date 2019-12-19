<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px solid">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${pageInfo.list }" var="peo">
			<tr>
				<td>${peo.id }</td>
				<td>${peo.name }</td>
				<td>${peo.age }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="page?pageSize=${pageInfo.pageSize }&pageNumber=${pageInfo.pageNumber-1}" <c:if test="${pageInfo.pageNumber<=1 }">onclick="javascript:return false"</c:if>>上一页</a>
	<a href="page?pageSize=${pageInfo.pageSize }&pageNumber=${pageInfo.pageNumber+1}" <c:if test="${pageInfo.pageNumber>=(pageInfo.total%pageInfo.pageSize==0?pageInfo.total/pageInfo.pageSize:pageInfo.total/pageInfo.pageSize+1)}">onclick="javascript:return false"</c:if>>下一页</a>
</body>
</html>