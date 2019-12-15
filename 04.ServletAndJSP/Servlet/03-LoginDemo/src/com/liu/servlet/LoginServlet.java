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
 * 处理请求Servlet
 * @author liujy
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.设置请求编码格式
		req.setCharacterEncoding(this.getServletContext().getInitParameter("reqCode"));
		//2.设置响应编码格式
		resp.setContentType(this.getServletContext().getInitParameter("respCode"));
		//3.获取请求信息
		String uname = (String) req.getParameter("uname");
		String pwd = (String) req.getParameter("pwd");
		//4.处理请求信息
		//使用mvc的思想处理数据
		LoginService ls = new LoginServiceImpl();
		User user = ls.checkLoginService(uname, pwd);
		if (user != null) { //登录成功
			//添加Cookie，实现三天免登陆
			Cookie ck = new Cookie("id", String.valueOf(user.getId()));
			//设置有效时长
			ck.setMaxAge(3*24*3600);
			ck.setPath("/logindemo/ck");
			resp.addCookie(ck);
			//创建session
			HttpSession hs = req.getSession();
			hs.setAttribute("user", user);
			//使用ServletContext对象实现网站计数器
			ServletContext sc = this.getServletContext();
			if (sc.getAttribute("nums") != null) {
				int nums = Integer.parseInt((String) sc.getAttribute("nums"));
				nums++;
				sc.setAttribute("nums",nums+"");
			} else {
				sc.setAttribute("nums","1");
			}
			//5.响应请求结果
			//重定向到主页面
			resp.sendRedirect("/logindemo/main");
			return;
		} else {	//登录失败，提示用户名或密码错误
			//请求转发到page
			req.setAttribute("str", "用户名或密码错误");
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
		
		
	}
}
