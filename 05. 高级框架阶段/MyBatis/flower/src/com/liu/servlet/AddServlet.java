package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.Flower;
import com.liu.service.FlowerService;
import com.liu.service.impl.FlowerServiceImpl;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	FlowerService flowerService = new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Flower flower = new Flower(0, req.getParameter("name"), Double.parseDouble(req.getParameter("price")), req.getParameter("production"));
		int index = flowerService.addFlower(flower);
		if (index>0) {
			resp.sendRedirect("/flower/ts");
			return;
		} else {
			resp.sendRedirect("/flower/add.jsp");
			return;
		}
	}
}
