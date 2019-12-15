package com.manager.service;

import java.util.List;

import com.manager.pojo.User;

/**
 * 用户处理业务层
 * @author liujy
 *
 */
public interface UserService {
	
	/**
	 * 校验用户登录信息
	 * @param uname	用户名
	 * @param pwd 密码
	 * @return User
	 */
	User checkUserLoginService(String uname, String pwd);

	/**
	 * 修改密码
	 * @param newPwd 新密码
	 * @param uid 用于ID
	 * @return
	 */
	int userChangePwdService(String newPwd, int uid);

	/**
	 * 查看用户信息
	 * @return
	 */
	List<User> userShowService();

	/**
	 * 用户注册
	 * @param u
	 * @return
	 */
	int userRegService(User u);
}
