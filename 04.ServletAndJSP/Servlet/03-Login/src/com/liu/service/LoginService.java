package com.liu.service;

import com.liu.bean.User;

public interface LoginService {
	//�����û���������У���û���Ϣ
	User checkLoginService(String uname, String pwd);
	//����idУ���û�
	User checkIdService(String id);
}
