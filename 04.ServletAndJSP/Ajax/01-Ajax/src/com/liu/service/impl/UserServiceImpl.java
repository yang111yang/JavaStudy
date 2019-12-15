package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.dao.impl.UserDaoImpl;
import com.liu.service.UserService;
import com.liu.vo.User;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();

	@Override
	public User getUserService(String name) {
		User user = ud.getUserDao(name);
		System.out.println(user);
		return user;
	}

}
