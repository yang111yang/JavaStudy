package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletConfig����ѧϰ��
 * 		���⣺
 * 			��λ�ȡ��web.xml�и�ÿ��servlet�������õ������أ�
 * 		�����
 * 			ʹ��ServletConfig����
 * 		ʹ�ã�
 * 			��ȡServletConfig����
 * 			��ȡweb.xml�е���������
 * @author liujy
 */
public class ServletConfigServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡServlet����
		ServletConfig sc = this.getServletConfig();
		String code = sc.getInitParameter("code");
		System.out.println(code);
	}
}