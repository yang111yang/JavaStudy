package com.liu.service.impl;

import com.liu.bean.User;
import com.liu.dao.LoginDao;
import com.liu.dao.impl.LoginDaoImpl;
import com.liu.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	LoginDao ld = new LoginDaoImpl();

	@Override
	public User checkLoginService(String uname, String pwd) {
		return ld.checkLoginDao(uname, pwd);
	}

	@Override
	public User checkIdService(String id) {
		return ld.checkIdDao(id);
	}

}
