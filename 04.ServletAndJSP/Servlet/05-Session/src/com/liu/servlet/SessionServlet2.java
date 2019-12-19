package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		HttpSession session = req.getSession();
		
		System.out.println("SS2:"+session.getId()+":"+session.getAttribute("name"));
		//处理请求信息
		//响应处理结果
			//直接响应
			resp.getWriter().write("SS2");
			//请求转发
			//重定向
	}
}
