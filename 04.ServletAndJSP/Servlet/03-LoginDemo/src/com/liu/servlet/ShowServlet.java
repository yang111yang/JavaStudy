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
		//1.设置请求编码格式
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2.设置响应编码格式
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		HttpSession hs = req.getSession();
		User u = (User) hs.getAttribute("user");
		
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
	}
}
