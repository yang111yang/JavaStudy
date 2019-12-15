<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	JSTL学习:
		作用:
			提高在jsp中的逻辑代码的编写效率，使用标签。
		使用：
			JSTL的核心标签库（重点）
			JSTL的格式化标签库（讲解）
			JSTL的SQL标签库(了解)
			JSTL的函数标签库(了解)
			JSTL的XML标签库(了解)
		JSTL的核心 标签库：
			1、导入jar包
			2、声明jstl标签库的引入(核心标签库)
				<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			3、内容:
				基本标签：
					<c:out value="数据" default="默认值"></c:out>
						数据可以为常量值也可以是EL表达式。
						作用：将数据输出给客户端。
					<c:set var="hello" value="hello pageContext" scope="page"></c:set>
						作用：存储数据到作用域对象中
						var：表示存储的键名
						value：表示存储的数据
						scope：表示要存储的作用域对象 page request session application
					<c:remove var="hello" scope="page"/>
						作用：删除作用域中的指定键的数据。
						var：表示要删除的键的名字
						scope：表示要删除的作用域（可选）
						注意：
							如果在不指定作用域的情况使用该标签删除数据，会将四个作用域对象中的符合要求的数据全部删除。
				逻辑标签：
					<c:if test="${表达式}">
							前端代码
					</c:if>
						作用：进行逻辑判断，相当于java代码的单分支判断。
						注意：
							逻辑判断标签需要依赖于EL的逻辑运算，也就是表达式中涉及到的数据必须从作用域中获取。
					<c:choose>
						<c:when test="">执行内容</c:when>
						<c:when test="">执行内容</c:when>
						...
						<c:otherwise>执行内容</c:otherwise>
					</c:choose>
						作用：用来进行多条件的逻辑判断，类似java中的多分支语句
						注意：
							条件成立只会执行一次，都不成立则执行otherwise	
				循环标签:
					<c:forEach begin="1" end="4" step="2">
							循环体
					</c:forEach>
					作用：
						循环内容进行处理
					使用:
						begin:声明循环开始位置
						end:声明循环结束位置
						step：设置步长
						varStatus:声明变量记录每次循环的数据(角标，次数，是否是第一次循环，是否是最后一次循环)
								注意:数据存储在作用域中，需要使用EL表达式获取。
								例如：${vs.index}--${vs.count}--${vs.first}--${vs.last}	
						items:声明要遍历的对象。结合EL表达式获取对象
						var:声明变量记录每次循环的结果。存储在作用域中，需要使用EL表达式获取。
--%>

<%
	/* request.setAttribute("hello", "hello pageContext"); */
%>
<!-- 基本标签 -->
<h3>基本标签</h3>
<hr/>
<c:out value="哈哈"></c:out>
<c:out value="${hello}"></c:out>
<c:set var="hello" value="hello pageContext" scope="page"></c:set>
<c:set var="hello" value="hello request" scope="request"></c:set>
<c:set var="hello" value="hello session" scope="session"></c:set>
<c:set var="hello" value="hello application" scope="application"></c:set>
<br/>
<c:out value="${pageScope.hello}"></c:out><br/>
<c:out value="${requestScope.hello}"></c:out><br/>
<c:out value="${sessionScope.hello}"></c:out><br/>
<c:out value="${applicationScope.hello}"></c:out><br/>

<!-- 逻辑标签 -->
<h3>逻辑标签</h3>
<hr>
<!-- 使用传统的方式进行逻辑判断 -->
<%
	int a = 4;
	if(a<5){
%>
		<b>我爱你中国</b>
<%} %>
<!-- 使用jstl标签库进行逻辑判断 -->
<c:set var="a" value="3"></c:set>
<c:if test="${a<5}">
	<b>我爱你中国</b>
</c:if><br>
<c:set var="score" value="95"></c:set>
<c:choose>
	<c:when test="${score>90}">
		<i>奖励吃鸡装备一套</i>
	</c:when>
	<c:when test="${score>80}">
		<i>奖励空投箱</i>
	</c:when>
	<c:when test="${score>70}">
		<i>奖励98k</i>
	</c:when>
	<c:otherwise>
		<i>男女混合双打</i>
	</c:otherwise>
</c:choose>

<!-- 循环标签 -->
<hr>
<h3>循环标签</h3>
<% 
	List<String> list = new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	request.setAttribute("list", list);
	Map<String, String> map = new HashMap<String,String>();
	map.put("city1", "北京");
	map.put("city2", "上海");
	map.put("city3", "广州");
	request.setAttribute("map", map);
%>

<c:forEach begin="0" end="2" step="2">
	bbbb<br/>
</c:forEach>

<!-- 动态获取循环长度 -->
<c:forEach items="${list}" varStatus="vs" var="name">
	${vs.index}--${vs.count}--${vs.first}--${vs.last}--${name}<br/>
</c:forEach>

<!-- 创建表格数据 -->
<table border="1px">
	<tr>
		<td>名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>价格</td>
	</tr>
	<c:forEach items="${list}" var="s">
		<tr>
			<td>${s}</td>
			<td>${s}</td>
			<td>${s}</td>
			<td>${s}</td>
		</tr>
	</c:forEach>
</table>

<c:forEach items="${map}" var="m">
	${m.key}--${m.value} <br/>
</c:forEach>