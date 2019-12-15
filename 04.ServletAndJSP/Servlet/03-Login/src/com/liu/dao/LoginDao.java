package com.liu.dao;

import com.liu.bean.User;

public interface LoginDao {

	/**
	 * 从数据库中查询指定用户的数据
	 * @param uname
	 * @param pwd
	 * @return
	 */
	User checkLoginDao(String uname, String pwd);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	User checkIdDao(String id);
	
}
