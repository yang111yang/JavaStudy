package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.PageInfo;
import com.liu.service.StudentService;
import com.liu.service.impl.StudentServiceImpl;
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	
	private StudentService stuService = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageSize = req.getParameter("pageSize");
		String pageNumber = req.getParameter("pageNumber");
		String sname = req.getParameter("sname");
		String tname = req.getParameter("tname");
		PageInfo pi = stuService.selByPage(pageSize, pageNumber, sname, tname);
		req.setAttribute("pageinfo", pi);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	
}
