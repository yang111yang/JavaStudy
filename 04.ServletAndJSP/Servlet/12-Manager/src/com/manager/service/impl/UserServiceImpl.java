package com.manager.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.manager.dao.UserDao;
import com.manager.dao.impl.UserDaoImpl;
import com.manager.pojo.User;
import com.manager.service.UserService;
/**
 * 用户处理业务层实现类
 * @author liujy
 *
 */
public class UserServiceImpl implements UserService {
	
	/** 声明日志对象 */
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	/** 创建UserDao对象 */
	UserDao ud = new UserDaoImpl();
	
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		logger.debug(uname+"发起登录请求");
		User u = ud.checkUserLoginDao(uname, pwd);
		if (u != null) {
			logger.debug(uname+"登录成功");
		} else {
			logger.debug(uname+"登录失败");
		}
		return u;
	}

	/**
	 * 修改密码
	 */
	@Override
	public int userChangePwdService(String newPwd, int uid) {
		logger.debug(uid+"发起修改密码请求");
		int index = ud.userChangePwdDao(newPwd, uid);
		if (index > 0) {
			logger.debug(uid+"修改密码成功");
		} else {
			logger.debug(uid+"修改密码失败");
		}
		return index;
	}

	/**
	 * 查看用户信息
	 */
	@Override
	public List<User> userShowService() {
		List<User> lu = ud.userShowDao();
		logger.debug("查询到的用户信息为："+lu);
		return lu;
	}
	
	/**
	 * 用户注册
	 */
	@Override
	public int userRegService(User u) {
		logger.debug(u.getUname()+"发起用户注册请求");
		int index = ud.userRegDao(u);
		if (index > 0) {
			logger.debug(u.getUname()+"用户注册成功");
		} else {
			logger.debug(u.getUname()+"用户注册失败");
		}
		return index;
	}

}
