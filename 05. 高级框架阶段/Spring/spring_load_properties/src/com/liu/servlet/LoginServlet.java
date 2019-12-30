package com.liu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac  = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String code = req.getParameter("validcode");
		HttpSession session = req.getSession();
		String validcode = (String) session.getAttribute("code");
		String msg = userService.selByUsername(username, password, code, validcode);
		System.out.println(msg);
		PrintWriter writer = resp.getWriter();
		writer.write(msg);
	}
	
}
