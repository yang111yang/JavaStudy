package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletConfig对象学习：
 * 		问题：
 * 			如何获取在web.xml中给每个servlet单独配置的数据呢？
 * 		解决：
 * 			使用ServletConfig对象
 * 		使用：
 * 			获取ServletConfig对象
 * 			获取web.xml中的配置数据
 * @author liujy
 */
public class ServletConfigServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取Servlet对象
		ServletConfig sc = this.getServletConfig();
		String code = sc.getInitParameter("code");
		System.out.println(code);
	}
}
