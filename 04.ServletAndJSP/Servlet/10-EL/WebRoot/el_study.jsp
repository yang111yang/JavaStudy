<%@ page language="java" import="java.util.*,com.liu.pojo.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 
	传统方式获取作用域数据:
		缺点一:导入包
		缺点二:需要强转
		缺点三:获取数据的代码过于麻烦。
	使用El表达式获取作用域数据:
		作用：获取作用域对象中的数据。
			注意：获取的是pageContext、request、session、application四个对象中的数据，其他数据一概不理会。
				找到了则获取返回，找不到则什么都不做，也不报错。
		语法：
			${表达式}
			表达式：
				获取请求数据
					request对象存储了请求数据--->param.键名	   	返回值
					request对象存储了请求数据--->paramvalues.键名 	返回的是数组
				通过setAttribute方法存储到作用域对象中的数据
					${键名} 返回键名所对应的值。
					注意：
						如果存储的是普通字符串则直接返回
						如果存储的是对象，则返回的是对象
									获取对象中的数据：
										普通对象
											${键名.属性名.属性名....}
										集合对象
											list集合--->${键名[角标]}
											map集合--->${键名.map集合存储的键名}
		作用域查找顺序：
			默认查找顺序：
			pageConext-->request--->session--->application
			注意：
				每次查找都是从小到大进行查找，找到了则获取，不再继续找了。
			指定查找：
				${pageScope.键名}---${requestScope.键名}--${sessionScope.键名}--${applicationScope.键名}
		El表达式的逻辑运算：
			${逻辑表达式}：&& || !
			${算术表达式}：+，-，*，/
			${关系表达式}：>,<,>=,==,!=,%
			特殊:
				三目运算
			注意：
				+表示加法运算，不表示字符链接。使用EL表达式进行字符链接会报错。
		EL的空值判断:
			${empty 键名}
			作用:
				判断键名对象的值是否存有数据。
		EL获取请求头数据和Cookie数据：
			请求头数据：
				${header}-->返回所有的请求头数据
				${header["键名"]}--->返回指定的键名的请求头数据
				${hedaerValues["键名"]}--->返回指定的键名(同键不同值)的值的数组。
			获取Cookie数据：
				${cookie}--->返回存储了所有的cookie对象的map集合
				${cookie.键名}---->返回指定的cookie对象
				${cookie.键名.name}--->返回指定的cookie对象存储的数据的键名。
				${cookie.键名.value}--->返回指定的cookie对象存储的数据的值。	
 --%>
<%-- <h3>使用传统方式获取作用域数据</h3>
<hr>
<b><%=request.getParameter("uname") %></b><br/>
<b><%=request.getAttribute("str") %></b><br/>
<b><%=((User)request.getAttribute("user")).getAddr().getTown() %></b><br/>
<b><%=((List<String>)request.getAttribute("list")).get(2) %></b><br/>
<b><%=((List<User>)request.getAttribute("list2")).get(0).getAddr().getTown() %></b><br/>
<b><%=((Map<String, String>)request.getAttribute("map")).get("c") %></b><br/>
<b><%=((User)((Map<String, User>)request.getAttribute("map2")).get("a1")).getAddr().getTown() %></b><br/> --%>
	
<h3>使用EL表达式获取作用域数据</h3>
<hr>
<b>${param.uname}</b><br/>
<b>${str}</b><br/>
<b>${user.addr.town}</b><br/>
<b>${list[2]}</b><br/>
<b>${list2[0].addr.town}</b><br/>
<b>${map.c}</b><br/>
<b>${map2.a1.addr.town}</b><br/>

<h3>使用EL表达式作用域查找</h3>
<hr>
<%
	pageContext.setAttribute("hello", "hello pageContext");
	request.setAttribute("hello", "hello request");
	session.setAttribute("hello", "hello session");
	application.setAttribute("hello", "hello application");
	request.setAttribute("sex", 1);
%>
${hello}<br/>
${pageScope.hello}--${requestScope.hello}--${sessionScope.hello}--${applicationScope.hello}

<h3>El表达式的逻辑运算</h3>
<hr>
${1+"1"}--${4-5}--${3*3}--${5/3}--${2>1&&1>2}--${2>1||1>2}--${!(1==2)}--${6%4}--${sex==1?'男':'女'}

<h3>EL的空值判断</h3>
<hr>
${empty s1}--${empty s2}--${empty s3}--${empty s4}

<h3>获取请求头数据和Cookie数据</h3>
<hr>
<!-- 获取请求头数据 -->
${header}--${headerValues["accept-language"][0]}<br/>
<!-- 获取Cookie数据 -->
${cookie}--${cookie.JSESSIONID}--${cookie.JSESSIONID.name}--${cookie.JSESSIONID.value}