package com.liu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.Address;
import com.liu.pojo.User;
/**
 * EL���ʽѧϰ
 * @author liujy
 *
 */
public class ElServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//����������Ϣ
		System.out.println(uname+":"+pwd);
		//��Ӧ������
		//ʹ��request���������������ת
		//��ͨ�ַ���
		req.setAttribute("str", "����������ã��ʺ�ѧϰ");
		//��������
		User user = new User(1, "�Ź���", "����", new Address("���", "���", "����"));
		req.setAttribute("user", user);
		//��������
		//List����
		//�洢��ͨ�ַ�
		List<String> list = new ArrayList<String>();
		list.add("����ΰ");
		list.add("�Ű�֥");
		list.add("�Ź���");
		//�洢����
		List<User> list2 = new ArrayList<User>();
		User u2=new User(2, "��������","�ĵ�Ӱ",new Address("�½�","��³ľ��","��³ľ��"));
		list2.add(u2);
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		
		//Map����
		//�洢��ͨ�ַ�
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "����");
		map.put("b", "�Ϻ�");
		map.put("c", "���");
		req.setAttribute("map", map);
		//�洢����
		Map<String,User> map2=new HashMap<String,User>();
		map2.put("a1", new User(3, "�����Ȱ�","�ĵ�Ӱ",new Address("�½�","��³��","��³��")));
		req.setAttribute("map2",map2);
		//��ֵ�ж�
		req.setAttribute("s1", "");
		req.setAttribute("s2", new User());
		req.setAttribute("s3", new ArrayList());
		req.setAttribute("s4", new HashMap());
		
		
		
		//����ת����el_study.jsp
		req.getRequestDispatcher("/el_study.jsp").forward(req, resp);
		return;
	}
}
