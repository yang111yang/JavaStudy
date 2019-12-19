package com.liu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request对象学习：
 * 		作用：request对象中封存了当前请求的所有请求信息
 * 		使用：
 * 			获取请求头数据
 * 					req.getMethod();//获取请求方式
 * 					req.getRequestURL();//获取请求URL信息
 * 					req.getRequestURI();//获取请求URI信息
 * 					req.getScheme();//获取协议
 * 			获取请求行数据
 * 					req.getHeader("键名");//返回指定的请求头信息
 * 					req.getHeaderNames();//返回请求头的键名的枚举集合
 * 			获取用户数据
 * 					req.getParameter("键名");//返回指定的用户数据
 * 					req.getParameterValues("键名");//返回同键不同值的请求数据(多选)，返回的数组。
 * 					req.getParameterNames()//返回所有用户请求数据的枚举集合
 * 			注意：
 * 				如果要获取的请求数据不存在，不会报错，返回null。
 * 
 * 		注意：
 * 			request对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法。
 * @author MyPC
 *
 */
public class RequestServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、获取请求头数据
		//1.1、获取请求方式
		String method = req.getMethod();
		System.out.println(method);
		//1.2、获取请求URL信息
		StringBuffer url = req.getRequestURL();
		System.out.println(url);
		//1.3、获取请求URI信息
		String uri = req.getRequestURI();
		System.out.println(uri);
		//1.4、获取协议
		String h = req.getScheme();
		System.out.println(h);
		//2、获取请求行数据
		//2.1、返回指定的请求头信息
		String value = req.getHeader("user-Agent");
		System.out.println(value);
		//2.2、返回请求头的键名的枚举集合
		Enumeration e = req.getHeaderNames();
		while (e.hasMoreElements()) {
			Object key = (Object) e.nextElement();
			String value2 = req.getHeader((String) key);
			System.out.println(key+":"+value2);
			
		}
		//3、获取用户数据
		//3.1、返回指定的用户数据
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		System.out.println(username+":"+pwd);
		//3.2、返回同键不同值的请求数据(多选)，返回的数组
		String[] favs = req.getParameterValues("fav");
		if (favs != null) {
			for (String fav : favs) {
				System.out.println(fav);
			}
		}
		//3.3、返回所有用户请求数据的枚举集合
		
	}

}
