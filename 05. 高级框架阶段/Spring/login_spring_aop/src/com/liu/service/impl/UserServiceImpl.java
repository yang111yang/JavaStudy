package com.liu.service.impl;

import java.util.List;

import com.liu.mapper.UserMapper;
import com.liu.pojo.User;
import com.liu.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<User> show(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> list = userMapper.selAll(user);
		System.out.println(list);
		return list;
	}

}
