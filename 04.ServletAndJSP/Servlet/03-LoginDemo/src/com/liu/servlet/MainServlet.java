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
 * ��ҳ��
 * @author liujy
 *
 */
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.������������ʽ
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2.������Ӧ�����ʽ
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		//��ȡSession����
		HttpSession hs = req.getSession();
		User u = (User) hs.getAttribute("user");
		
		//��Ӧ������
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h3>��ӭ"+u.getUname()+"��½�༶����ϵͳ</h3>");
		resp.getWriter().write("<hr/>");
		resp.getWriter().write("��վ�����ʵĴ�����"+this.getServletContext().getAttribute("nums"));
		resp.getWriter().write("<form action='show' method='get'>");
		resp.getWriter().write("<input type='submit' value='��ѯ������Ϣ'/>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
	}
}
