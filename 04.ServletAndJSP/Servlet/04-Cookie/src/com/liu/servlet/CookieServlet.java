package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Cookieѧϰ:
 * 		����:����˷��͵Ĳ�ͬ��������ݹ�������
 * 		ʹ��:
 * 			Cookie�Ĵ����ʹ洢
 * 				//����Cookie����
 * 					Cookie c=new Cookie(String name, String value);
 * 				//����cookie(��ѡ)
 * 					//������Ч��
 * 					c.setMaxAge(int seconds);
 *					//������Ч·��
 *					c.setPath(String uri)
 *				//��ӦCookie��Ϣ���ͻ���
 *					resp.addCookie(c);
 *			Cookie�Ļ�ȡ
 *				//��ȡCookie��Ϣ����
 *				Cookie[] cks=req.getCookies();
 *				//���������ȡCookie��Ϣ
 *					ʹ��forѭ���������ɣ�ʾ����
	 					if(cks!=null){
							for(Cookie c:cks){
								String name=c.getName();
								String value=c.getValue();
								System.out.println(name+":"+value);
							}
						}
 *		ע��:
 *			һ��Cookie����洢һ�����ݡ��������ݣ����Զഴ������Cookie������д洢��
 *		�ص�:
 *			������˵����ݴ洢������
 *			�洢�����������ڷ������ˡ�
 *			��ʱ�洢:�洢��������������ڴ��У�������رռ�ʧЧ��
 *			��ʱ�洢:������Cookie����Ч�ڣ��洢�ڿͻ��˵�Ӳ���У�����Ч���ڷ���·��Ҫ������󶼻ḽ������Ϣ��
 *			Ĭ��cookie��Ϣ�洢��֮��ÿ�����󶼻ḽ��������������Ч·��
 * @author MyPC
 *
 */
public class CookieServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		//����������Ϣ
		//Cookie��ʹ��
		Cookie c = new Cookie("key", "������");
		//����Cookie
		c.setMaxAge(3*24*3600);
		//����Cookie����
		resp.addCookie(c);
		//��Ӧ�������
		resp.getWriter().write("Cookieѧϰ");
	}

}