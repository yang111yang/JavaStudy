package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.PageInfo;
import com.liu.service.PeopleService;
import com.liu.service.impl.PeopleServiceImpl;
@WebServlet("/page")
public class PageServlet extends HttpServlet {
	private PeopleService ps = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageSizestr = req.getParameter("pageSize");
		int pageSize = 2;
		if (pageSizestr!=null&&!pageSizestr.equals("")) {
			pageSize = Integer.parseInt(pageSizestr);
		}
		String pageNumberstr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if (pageNumberstr!=null&&!pageNumberstr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberstr);
		}
		
		PageInfo pi = ps.showPage(pageSize, pageNumber);
		req.setAttribute("pi", pi);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
