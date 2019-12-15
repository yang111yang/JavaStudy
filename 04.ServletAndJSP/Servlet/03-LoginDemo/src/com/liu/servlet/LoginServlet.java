package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.bean.User;
import com.liu.service.LoginService;
import com.liu.service.impl.LoginServiceImpl;
/**
 * ��������Servlet
 * @author liujy
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.������������ʽ
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2.������Ӧ�����ʽ
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		//3.��ȡ������Ϣ
		String uname = (String) req.getParameter("uname");
		String pwd = (String) req.getParameter("pwd");
		//4.����������Ϣ
		//ʹ��mvc��˼�봦������
		LoginService ls = new LoginServiceImpl();
		User user = ls.checkLoginService(uname, pwd);
		if (user != null) { //��¼�ɹ�
			//���Cookie��ʵ���������½
			Cookie ck = new Cookie("id", String.valueOf(user.getId()));
			//������Чʱ��
			ck.setMaxAge(3*24*3600);
			ck.setPath("/logindemo/ck");
			resp.addCookie(ck);
			//����session
			HttpSession hs = req.getSession();
			hs.setAttribute("user", user);
			//ʹ��ServletContext����ʵ����վ������
			ServletContext sc = this.getServletContext();
			if (sc.getAttribute("nums") != null) {
				int nums = Integer.parseInt((String) sc.getAttribute("nums"));
				nums++;
				sc.setAttribute("nums",nums+"");
			} else {
				sc.setAttribute("nums","1");
			}
			//5.��Ӧ������
			//�ض�����ҳ��
			resp.sendRedirect("/logindemo/main");
			return;
		} else {	//��¼ʧ�ܣ���ʾ�û������������
			//����ת����page
			req.setAttribute("str", "�û������������");
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
		
		
	}
}
