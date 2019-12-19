package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet���������ڣ�
 * 		1.�ӵ�һ�ε��õ��������رա�
 * 		2.���Servlet��web.xml��������load-on-startup����������Ϊ�ӷ������������������ر�
 * ע�⣺
 * 		init�����Ƕ�Servlet���г�ʼ����һ������������Servlet��һ�μ��ؽ��ڴ�ʱִ��
 * 		destory��������servlet������ʱִ�У�Ҳ���Ƿ������ر�ʱ��
 * @author liujy
 *
 */
public class MyServlet2 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("servlet��ʼ��......");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("servlet life");
		System.out.println("servlet life");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet��������......");
	}
	

}
