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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String uname = (String) req.getParameter("uname");
		//��ȡ�����е�session����
		HttpSession hs = req.getSession();
		//�ж��û����ݶ����Ƿ�Ϊnull
		if (hs.getAttribute("user") == null) { //����û�����Ϊnull�����ض��򵽵�¼ҳ��
			resp.sendRedirect("/login/ck");
			return;
		}
		//����û�����Ϊnull����������
		User u = (User) hs.getAttribute("user");
		//����������Ϣ
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
