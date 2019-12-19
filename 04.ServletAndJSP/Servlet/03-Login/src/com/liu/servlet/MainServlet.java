package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.bean.User;

public class MainServlet extends HttpServlet {

	private static final String String = null;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String uname = (String) req.getParameter("uname");
		//获取请求中的session数据
		HttpSession hs = req.getSession();
		//判断用户数据对象是否为null
		if (hs.getAttribute("user") == null) { //如果用户对象为null，则重定向到登录页面
			resp.sendRedirect("/login/ck");
			return;
		}
		//如果用户对象不为null，则处理数据
		User u = (User) hs.getAttribute("user");
		//处理请求信息
		//响应处理结果
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h3>欢迎"+u.getUname()+"登陆班级管理系统</h3>");
		resp.getWriter().write("<hr/>");
		resp.getWriter().write("网站被访问的次数："+this.getServletContext().getAttribute("nums"));
		resp.getWriter().write("<form action='show' method='get'>");
		resp.getWriter().write("<input type='submit' value='查询个人信息'/>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
	}
	
}
