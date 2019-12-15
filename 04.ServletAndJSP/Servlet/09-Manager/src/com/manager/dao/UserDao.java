package com.manager.dao;

import java.util.List;

import com.manager.pojo.User;

/**
 * 用户数据数据库处理层
 * @author liujy
 *
 */
public interface UserDao {
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param uname	用户名
	 * @param pwd 密码
	 * @return	查询到的用户
	 */
	User checkUserLoginDao(String uname, String pwd);

	/**
	 * 根据用户ID修改用户密码
	 * @param newPwd 新密码
	 * @param uid 用户ID
	 * @return
	 */
	int userChangePwdDao(String newPwd, int uid);

	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<User> userShowDao();

	/**
	 * 用户注册
	 * @param u
	 * @return
	 */
	int userRegDao(User u);
}
