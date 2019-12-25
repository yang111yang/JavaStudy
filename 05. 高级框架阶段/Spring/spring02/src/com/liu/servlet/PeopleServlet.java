package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.liu.service.PeopleService;

@WebServlet("/show")
public class PeopleServlet extends HttpServlet {
	
	private PeopleService peopleService;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", peopleService.showPeople());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		//对service进行实例化
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		peopleService = ac.getBean("peopleService",PeopleService.class);
	}
	
	
	
}
