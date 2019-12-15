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
		//1.������������ʽ
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2.������Ӧ�����ʽ
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		HttpSession hs = req.getSession();
		User u = (User) hs.getAttribute("user");
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<table border='1px'>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>�û���");
		resp.getWriter().write("</td>");
		resp.getWriter().write("<td>"+u.getUname());
		resp.getWriter().write("</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<td>����");
		resp.getWriter().write("</td>");
		resp.getWriter().write("<td>"+u.getPwd());
		resp.getWriter().write("</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("</table>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
	}
}