package com.liu.service;

import java.util.List;

import com.liu.pojo.User;

public interface UserService {
	
	List<User> show(String username, String password);
	
}
