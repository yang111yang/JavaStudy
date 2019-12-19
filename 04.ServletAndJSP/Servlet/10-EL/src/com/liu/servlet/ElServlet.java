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
 * EL表达式学习
 * @author liujy
 *
 */
public class ElServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//处理请求信息
		System.out.println(uname+":"+pwd);
		//响应处理结果
		//使用request作用域进行数据流转
		//普通字符串
		req.setAttribute("str", "今天天气真好，适合学习");
		//对象类型
		User user = new User(1, "张国荣", "唱歌", new Address("香港", "香港", "九龙"));
		req.setAttribute("user", user);
		//集合类型
		//List集合
		//存储普通字符
		List<String> list = new ArrayList<String>();
		list.add("梁朝伟");
		list.add("张柏芝");
		list.add("张国荣");
		//存储对象
		List<User> list2 = new ArrayList<User>();
		User u2=new User(2, "古力娜扎","拍电影",new Address("新疆","乌鲁木齐","乌鲁木齐"));
		list2.add(u2);
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		
		//Map集合
		//存储普通字符
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "北京");
		map.put("b", "上海");
		map.put("c", "天津");
		req.setAttribute("map", map);
		//存储对象
		Map<String,User> map2=new HashMap<String,User>();
		map2.put("a1", new User(3, "迪丽热巴","拍电影",new Address("新疆","吐鲁番","吐鲁番")));
		req.setAttribute("map2",map2);
		//空值判断
		req.setAttribute("s1", "");
		req.setAttribute("s2", new User());
		req.setAttribute("s3", new ArrayList());
		req.setAttribute("s4", new HashMap());
		
		
		
		//请求转发到el_study.jsp
		req.getRequestDispatcher("/el_study.jsp").forward(req, resp);
		return;
	}
}
