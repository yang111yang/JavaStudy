package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.bean.User;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			//获取请求中的session对象信息
			HttpSession hs = req.getSession();
			//对session对象中的数据进行判断
			if (hs.getAttribute("user") == null) {
				//数据为null，重定向到登录页面
				resp.sendRedirect("/login/ck");
				return;
			}
			//如果session对象中的数据不为null，则获取数据
			User u = (User) hs.getAttribute("user");
		//处理请求信息
		//响应处理结果
			//直接响应
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			resp.getWriter().write("<table border='1px'>");
			resp.getWriter().write("<tr>");
			resp.getWriter().write("<td>用户名");
			resp.getWriter().write("</td>");
			resp.getWriter().write("<td>"+u.getUname());
			resp.getWriter().write("</td>");
			resp.getWriter().write("</tr>");
			resp.getWriter().write("<tr>");
			resp.getWriter().write("<td>密码");
			resp.getWriter().write("</td>");
			resp.getWriter().write("<td>"+u.getPwd());
			resp.getWriter().write("</td>");
			resp.getWriter().write("</tr>");
			resp.getWriter().write("</table>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
			//请求转发
			//重定向
	}
}
