package com.liu.service;

import com.liu.bean.User;

public interface LoginService {
	//根据用户名和密码校验用户信息
	User checkLoginService(String uname, String pwd);
	//根据id校验用户
	User checkIdService(String id);
}
