package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.bean.User;
import com.liu.service.LoginService;
import com.liu.service.impl.LoginServiceImpl;

/**
 * ��������������:
 * 	1��ʹ��String�����������±���
 * 			uname=new String(uname.getBytes("iso8859-1"),"utf-8");
 *  2��ʹ�ù�������
 * 		get��ʽ��
 * 			����һ��req.setCharacterEncoding("utf-8");
 * 			�������
 * 				��tomcat��Ŀ¼�µ�confĿ¼���޸�server.xml�ļ�����Connector��ǩ���������� useBodyEncodingForURI="true"
 * 		post��ʽ��
 * 			req.setCharacterEncoding("utf-8");
 * Servlet�����ܽ�:
 * 		������������󵽷�����(����)
 *      ��������������������󣬽��н���������request����洢��������
 *      ���������ö�Ӧ��servlet��������������request������Ϊʵ�δ��ݸ�servlet�ķ���
 *      servlet�ķ���ִ�н���������
 *      		//������������ʽ
 *      		//������Ӧ�����ʽ
 *      		//��ȡ������Ϣ
 *      		//����������Ϣ
 *      			//����ҵ������
 *      			//����ҵ������ķ���
 *      		//��Ӧ������
 *����ת��ѧϰ��
 *		����:ʵ�ֶ��servlet������������������������������࣬��servlet��ְ�������ȷ��
 *		ʹ�ã�
 *				req.getRequestDispatcher("Ҫת���ĵ�ַ").forward(req, resp);
 *				��ַ�����·����ֱ����дservlet�ı������ɡ�
 *		�ص�:
 *			һ�������������ַ����Ϣ���ı䡣
 *		ע�⣺
 *			����ת����ֱ��return�������ɡ�
 *reuqet������
 *		�����һ�������ڵ�servlet�����ݹ�������
 *�ض���
 *		����˱��ظ��ύ�����⣬�Լ���ǰservlet�޷��������������⡣
 *		ʹ��:
 *			resp.sendRedirect(String uri);
 *		ʾ��:
 *			resp.sendRedirect("/login/main");
 *		�ص㣺
 *			������������request����
 *			�������ַ����Ϣ�ı�
 *		ʱ����
 *			����������б����ݣ��������ֱȽ���Ҫ�������ظ��ύ������ʹ���ض���
 *			�������Servlet���պ��޷����д�������ʹ���ض���λ�����Դ������Դ��	
 *
 *�����ҳ���û�����ʾΪnull�����⣺
 *		ԭ��
 *			��Ϊ���û���¼�ɹ���ʹ���ض�����ʾ��ҳ�棬�������󣬶��û�����Ϣ
 *			�ڵ�һ�������У��ڶ���������û���û����ݣ�������ʾΪnull
 *		���:
 *			ʹ��session
 *ʹ��ServletContext���������ҳ������
 *		���û���¼У���д�����������������Ȼ��洢��ServletContext������
 *		����ҳ����ȡ��������������ʾ���û����ɡ�
 * @author liujy
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������ʽ
		String uname = req.getParameter("uname");
		uname = new String(uname.getBytes("ISO-8859-1"), "utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String pwd = req.getParameter("pwd");
		//System.out.println(uname+":"+pwd);
		//����������Ϣ
		LoginService ls = new LoginServiceImpl();
		User u = ls.checkLoginService(uname, pwd);
		if (u != null) {
			//resp.getWriter().write("��¼�ɹ�");
			//����ת��
			//req.getRequestDispatcher("main").forward(req, resp);
			//return;
			//����Cookie���洢���������ʵ���������½
			Cookie c = new Cookie("id", u.getId()+"");
			//����cookie�Ĵ洢����
			c.setMaxAge(3*24*3600);
			//���ø���cookie���ݵ�uri
			c.setPath("login/ck");
			//���cookie
			resp.addCookie(c);
			//ʹ��session�洢�û�����
			req.getSession().setAttribute("user", u);
			
			//ʹ��ServletContext����ʵ����վ������
			ServletContext sc = this.getServletContext();
			if (sc.getAttribute("nums") == null) {
				sc.setAttribute("nums", "1");
			} else {
				int nums = Integer.parseInt((String) sc.getAttribute("nums"));
				nums++;
				sc.setAttribute("nums", nums+"");
			}
			
			//ʹ���ض���
			resp.sendRedirect("/login/main");
		} else {
//			resp.getWriter().write("��¼ʧ��");
			
			//ʹ��request�������򣬽������Servlet֮������ݹ�������
			req.setAttribute("str", "�û������������");
			
			//����ת������¼ҳ��
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
		
	}

}
