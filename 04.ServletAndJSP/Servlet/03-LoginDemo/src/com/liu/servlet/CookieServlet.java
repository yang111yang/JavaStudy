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
		// 获取Cookie
		Cookie[] cks = req.getCookies();
		if (cks != null) {
			String id = "";
			//有Cookie
			for (Cookie ck : cks) {
				if ("id".equals(ck.getName())) {
					id = ck.getValue();
					LoginService ls = new LoginServiceImpl();
					User u = ls.checkIdService(id);
					if (u != null) {
						//创建Session对象
						HttpSession hs = req.getSession();
						hs.setAttribute("user", u);
						
						//使用ServletContext对象实现网站计数器
						ServletContext sc = this.getServletContext();
						if (sc.getAttribute("nums") != null) {
							int nums = Integer.parseInt((String) sc.getAttribute("nums"));
							nums++;
							sc.setAttribute("nums",nums+"");
						} else {
							sc.setAttribute("nums","1");
						}
						
						//登录成功，重定向到main
						resp.sendRedirect("/logindemo/main");
						return;
					} else {
						//登录失败，请求转发到page
						req.getRequestDispatcher("page").forward(req, resp);
						return;
					}
				} else {
					//cookie中没有id，请求转发到page
					req.getRequestDispatcher("page").forward(req, resp);
					return;
				}
			}
		} else {
			//没有Cookie，请求转发到page
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
		
	}
}
