package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.bean.User;
import com.liu.service.LoginService;
import com.liu.service.impl.LoginServiceImpl;
/**
 * ����Cookie
 * @author liujy
 *
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡCookie
		Cookie[] cks = req.getCookies();
		//����Cookie
		if (cks != null) {
			String id = "";
			for (Cookie c : cks) {
				if ("id".equals(c.getName())) {
					id = c.getValue();
				}
			}
			//�ж�id�Ƿ�Ϊ��
			if (!"".equals(id)) {
				//�����ݿ��ѯid
				LoginService ls = new LoginServiceImpl();
				User u = ls.checkIdService(id);
				if (u != null) {
					//�������½����¼�ɹ�֮��Ҫ���û����ݴ洢��session������
					req.getSession().setAttribute("user", u);
					//ʵ����վ������
					ServletContext sc = this.getServletContext();
					if (sc.getAttribute("nums") == null) {
						sc.setAttribute("nums", "1");
					} else {
						int nums = Integer.parseInt((String) sc.getAttribute("nums"));
						nums++;
						sc.setAttribute("nums", nums+"");
					}
					//�û����ڣ��ض�����ҳ��
					resp.sendRedirect("/login/main");
					return;
				} else {
					//�û������ڣ�����ת������¼ҳ��
					req.getRequestDispatcher("page").forward(req, resp);
					return;
				}
			} else {
				//idΪ�գ�����ת������¼ҳ��
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			}
		} else {
			//cookie�����ڣ�����ת������¼ҳ��
			req.getRequestDispatcher("page").forward(req, resp);
			return;
			
		}
	}
}
