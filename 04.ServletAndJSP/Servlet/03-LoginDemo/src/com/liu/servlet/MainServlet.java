package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.bean.User;

/**
 * 主页面
 * @author liujy
 *
 */
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.设置请求编码格式
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2.设置响应编码格式
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		//获取Session对象
		HttpSession hs = req.getSession();
		User u = (User) hs.getAttribute("user");
		
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
