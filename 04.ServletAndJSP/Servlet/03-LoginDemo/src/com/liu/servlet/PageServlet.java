package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登录页面
 * @author liujy
 *
 */
public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、设置请求编码格式
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2、设置响应编码格式
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		//3、获取请求信息
		String str = (String) req.getAttribute("str")==null?"":(String) req.getAttribute("str");
		//4、处理请求信息
		//5、响应处理结果
		//5.1、直接响应
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<font color='red' size='20px'>"+str+"</font>");
		resp.getWriter().write("<form action='login' method='get'>");
		resp.getWriter().write("用户名：<input type='text' name='uname' value=''/><br/>");
		resp.getWriter().write("密码：<input type='password' name='pwd' value=''/><br/>");
		resp.getWriter().write("<input type='submit' value='登录'/>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		//5.2、请求转发
		//5.3、重定向
	}
}
