package com.liu.dao;

import com.liu.bean.User;

public interface LoginDao {

	/**
	 * 根据用户名和密码获取用户信息
	 * @param uname	用户名
	 * @param pwd	密码
	 * @return User
	 */
	User checkLoginDao(String uname,String pwd);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return User
	 */
	User checkIdDao(String id);
	
}
