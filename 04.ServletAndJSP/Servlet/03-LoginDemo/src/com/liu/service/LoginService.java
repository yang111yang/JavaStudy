package com.liu.service;

import com.liu.bean.User;

public interface LoginService {
	/**
	 * �����û����������ȡ�û���Ϣ
	 * @param uname	�û���
	 * @param pwd	����
	 * @return	User�û���Ϣ
	 */
	User checkLoginService(String uname,String pwd);

	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return User
	 */
	User checkIdService(String id);
}
