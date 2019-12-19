package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��¼ҳ��
 * @author liujy
 *
 */
public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1��������������ʽ
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2��������Ӧ�����ʽ
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		//3����ȡ������Ϣ
		String str = (String) req.getAttribute("str")==null?"":(String) req.getAttribute("str");
		//4������������Ϣ
		//5����Ӧ������
		//5.1��ֱ����Ӧ
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<font color='red' size='20px'>"+str+"</font>");
		resp.getWriter().write("<form action='login' method='get'>");
		resp.getWriter().write("�û�����<input type='text' name='uname' value=''/><br/>");
		resp.getWriter().write("���룺<input type='password' name='pwd' value=''/><br/>");
		resp.getWriter().write("<input type='submit' value='��¼'/>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		//5.2������ת��
		//5.3���ض���
	}
}
