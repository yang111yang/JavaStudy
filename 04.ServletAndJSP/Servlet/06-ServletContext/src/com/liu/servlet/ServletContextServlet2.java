package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//使用ServletContext对象获取数据
		ServletContext sc = this.getServletContext();
		Object str = sc.getAttribute("str");
		System.out.println("ServletContextServlet2.service()"+str);
	}
}
