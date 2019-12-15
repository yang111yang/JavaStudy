package com.liu.service;

import com.liu.bean.User;

public interface LoginService {
	/**
	 * 根据用户名和密码获取用户信息
	 * @param uname	用户名
	 * @param pwd	密码
	 * @return	User用户信息
	 */
	User checkLoginService(String uname,String pwd);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return User
	 */
	User checkIdService(String id);
}
