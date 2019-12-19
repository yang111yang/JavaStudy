package com.liu.service.impl;

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
	public String selByUsername(String username, String password,String code,String validcode) {
		User user = userMapper.selByUsername(username);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				if (code.equals(validcode)) {
					return "��¼�ɹ�";
				} else {
					return "��֤�벻��ȷ";
				}
			} else {
				return "�������";
			}
		}else {
			return "�û�������";
		}
	}

}
