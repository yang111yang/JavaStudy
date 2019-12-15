package com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.manager.pojo.User;
import com.manager.service.UserService;
import com.manager.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	
	/** 声明日志对象 */
	Logger logger = Logger.getLogger(UserServlet.class);
	
	/** 声明业务层对象 */
	UserService us = new UserServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		if ("login".equals(oper)) {
			//调用登录处理方法
			checkLogin(req,resp);
		} else if ("out".equals(oper)) {
			//调用退出处理方法
			userOut(req,resp);
		} else if ("pwd".equals(oper)) {
			//调用修改密码处理方法
			userChangePwd(req,resp);
		} else if ("show".equals(oper)) {
			//调用查看用户处理方法
			userShow(req,resp);
		} else if ("reg".equals(oper)) {
			//调用注册处理方法
			userReg(req,resp);
		} else {
			logger.debug("找不到操作符："+oper);
		}
		
	}
	
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求数据
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		int age = req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
		String birth = req.getParameter("birth");
		if (birth != "") {
			String[] bs = birth.split("/");
			birth = bs[2]+"-"+bs[0]+"-"+bs[1];
		} else {
			birth = null;
		}
		User u = new User(0, uname, pwd, sex, age, birth);
		//处理请求数据
		//调用业务层
		int index = us.userRegService(u);
		//创建session对象
		HttpSession hs = req.getSession();
		//响应处理结果
		if (index > 0) {
			hs.setAttribute("flag", 2);
			//注册成功，重定向到登录页面
			resp.sendRedirect("/manager/login.jsp");
			return;
		} else {
			hs.setAttribute("flag", 3);
			//注册失败，重定向到登录页面
			resp.sendRedirect("/manager/login.jsp");
			return;
		}
		
	}

	/**
	 * 查看用户处理方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//调用service方法
		List<User> lu = us.userShowService();
		if (lu != null) {
			//添加attribute属性
			req.setAttribute("users", lu);
			//重定向到登录页面
			req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
			return;
		}
	}

	/**
	 * 修改密码处理方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求数据
		String newPwd = req.getParameter("newPwd");
		User u = (User) req.getSession().getAttribute("user");
		int uid = u.getUid();
		//处理请求数据
		int index = us.userChangePwdService(newPwd, uid);
		if (index > 0) {
			//创建session对象
			HttpSession hs = req.getSession();
			hs.setAttribute("flag", 1);
			//密码修改成功，重定向到登录页面
			resp.sendRedirect("/manager/login.jsp");
			return;
		}
	}

	/**
	 * 退出处理方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session对象
		HttpSession hs = req.getSession();
		//强制销毁session对象
		hs.invalidate();
		//重定向到登录页面
		resp.sendRedirect("/manager/login.jsp");
		return;
	}
	
	/**
	 * 登录处理方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//处理请求信息
		User u = us.checkUserLoginService(uname, pwd);
		//响应处理结果（直接响应、请求转发、重定向）
		if (u != null) { // 登录成功
			//创建session对象
			HttpSession hs = req.getSession();
			//添加session
			hs.setAttribute("user", u);
			resp.sendRedirect("/manager/main/main.jsp");
			return;
		} else { // 登录失败
			//设置标识符
			req.setAttribute("flag", 0);
			//请求转发到登录页面
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
	}

}
