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
 * 处理Cookie
 * @author liujy
 *
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Cookie
		Cookie[] cks = req.getCookies();
		//遍历Cookie
		if (cks != null) {
			String id = "";
			for (Cookie c : cks) {
				if ("id".equals(c.getName())) {
					id = c.getValue();
				}
			}
			//判断id是否为空
			if (!"".equals(id)) {
				//到数据库查询id
				LoginService ls = new LoginServiceImpl();
				User u = ls.checkIdService(id);
				if (u != null) {
					//三天免登陆，登录成功之后要把用户数据存储到session对象中
					req.getSession().setAttribute("user", u);
					//实现网站计数器
					ServletContext sc = this.getServletContext();
					if (sc.getAttribute("nums") == null) {
						sc.setAttribute("nums", "1");
					} else {
						int nums = Integer.parseInt((String) sc.getAttribute("nums"));
						nums++;
						sc.setAttribute("nums", nums+"");
					}
					//用户存在，重定向到主页面
					resp.sendRedirect("/login/main");
					return;
				} else {
					//用户不存在，请求转发到登录页面
					req.getRequestDispatcher("page").forward(req, resp);
					return;
				}
			} else {
				//id为空，请求转发到登录页面
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			}
		} else {
			//cookie不存在，请求转发到登录页面
			req.getRequestDispatcher("page").forward(req, resp);
			return;
			
		}
	}
}
