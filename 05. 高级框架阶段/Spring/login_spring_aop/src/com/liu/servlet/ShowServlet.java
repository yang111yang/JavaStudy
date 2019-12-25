package com.liu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.liu.pojo.User;
import com.liu.service.UserService;
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		//��service����ʵ����
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService = ac.getBean("userService",UserService.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		List<User> list = userService.show(username, password);
		PrintWriter writer = resp.getWriter();
		if (list.size()>0) {
			writer.write("��ѯ�ɹ�");
		} else {
			writer.write("��ѯʧ��");
		}
	}
	
}
