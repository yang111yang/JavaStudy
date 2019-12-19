package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.PageInfo;
import com.liu.service.LogService;
import com.liu.service.impl.LogServiceImpl;
@WebServlet("/show")
public class ShowLogServlet extends HttpServlet {
	LogService ls = new LogServiceImpl();
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
		PageInfo pageInfo = ls.showLog(pageSize, pageNumber);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
	}
}
