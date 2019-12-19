package com.liu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.Flower;
import com.liu.service.FlowerService;
import com.liu.service.impl.FlowerServiceImpl;
@WebServlet("/ts")
public class SelServlet extends HttpServlet {
	FlowerService flowerService = new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Flower> list = flowerService.selAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		return;
	}
	
}
