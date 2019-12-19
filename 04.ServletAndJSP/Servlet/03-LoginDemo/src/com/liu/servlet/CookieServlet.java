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

public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡCookie
		Cookie[] cks = req.getCookies();
		if (cks != null) {
			String id = "";
			//��Cookie
			for (Cookie ck : cks) {
				if ("id".equals(ck.getName())) {
					id = ck.getValue();
					LoginService ls = new LoginServiceImpl();
					User u = ls.checkIdService(id);
					if (u != null) {
						//����Session����
						HttpSession hs = req.getSession();
						hs.setAttribute("user", u);
						
						//ʹ��ServletContext����ʵ����վ������
						ServletContext sc = this.getServletContext();
						if (sc.getAttribute("nums") != null) {
							int nums = Integer.parseInt((String) sc.getAttribute("nums"));
							nums++;
							sc.setAttribute("nums",nums+"");
						} else {
							sc.setAttribute("nums","1");
						}
						
						//��¼�ɹ����ض���main
						resp.sendRedirect("/logindemo/main");
						return;
					} else {
						//��¼ʧ�ܣ�����ת����page
						req.getRequestDispatcher("page").forward(req, resp);
						return;
					}
				} else {
					//cookie��û��id������ת����page
					req.getRequestDispatcher("page").forward(req, resp);
					return;
				}
			}
		} else {
			//û��Cookie������ת����page
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
		
	}
}
