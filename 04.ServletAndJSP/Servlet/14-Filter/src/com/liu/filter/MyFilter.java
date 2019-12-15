package com.liu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ��������ʹ�ã�
 * 	���ã�
 * 		�Է��������ܵ�������Դ����Ӧ�����������Դ���й���
 * 		����servlet
 * 	ʹ��:
 * 		����һ��ʵ����Filter�ӿڵ���ͨjava��
 * 		��д�ӿڵķ���
 * 			init����:������������ִ�С���Դ��ʼ��
 * 			doFilter����:��������ķ������ڴ˷����п��Զ���Դʵ�ֹ���
 * 					ע�⣺
 * 						��Ҫ�ֶ���������з��С�chain.doFilter(request, response);
 * 			destory�������������ر�ִ�С�
 *		��web.xml�����ù�����
 *			 	<filter>
				  	<filter-name>myFilter</filter-name>
				  	<filter-class>com.bjsxt.filter.MyFilter</filter-class>
				</filter>
			  	<filter-mapping>
			  		<filter-name>myFilter</filter-name>
			  		<url-pattern>/*</url-pattern>
			  	</filter-mapping>
			  ע��:
			  	url-pattern:/*
			  			��ʾ�������е�����
			  	url-pattern:*.do
			  			��ʾ������.do��β������һ������������ģ�����ش���
			  	url-pattern:/ts
			  			��ʾ����ָ��url���������ĳ��servlet������������أ�����servlet��
		���������������ڣ�
			�������������������رա�
		�ܽ�:
			����������Ա���������ã����������������е�uri��Ϣ���á�
		ִ��:
			������������󵽷����������������յ�����󣬸���URI��Ϣ��web.xml���ҵ���Ӧ��
			������ִ��doFilter�������÷����Դ˴�������д�����������Ҫ������У����к�
			������з���Ҫ��Ĺ�����������й��ˣ��ҵ�ִ�ж�Ӧ��servlet����������servlet��
			��������Ϻ�Ҳ��service���������ˡ��������������Ӧ��doFilter��������ִ�С�
			
		������
			ͳһ�����ʽ���á�
			session����
			Ȩ�޹���
			��Դ����ͳһˮӡ����г�ʻ�ȵȣ�
			
 * @author MyPC
 *
 */
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy(�ұ�������)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter.doFilter(�ұ�ִ����)");
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//�ж�session
		HttpSession hs = ((HttpServletRequest)req).getSession();
		if (hs.getAttribute("user") == null) {
			//�ض��򵽵�¼ҳ��
			((HttpServletResponse)resp).sendRedirect("/a/login.jsp");
		} else {
			//֪ͨ����������ת����ִ����ȥ��
			chain.doFilter(req, resp);
		}
		
		System.out.println("MyFilter.doFilter(�ұ�ִ����2)");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter.init(�ұ���ʼ����)");
	}

}
