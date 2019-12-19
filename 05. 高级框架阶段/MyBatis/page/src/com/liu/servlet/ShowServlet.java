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
public class ShowServlet extends HttpServlet {
	private PeopleService ps = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 2;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if (pageNumberStr != null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo pageInfo = ps.showPage(pageSize, pageNumber);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
