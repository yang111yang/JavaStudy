package com.liu.dao;

import com.liu.bean.User;

public interface LoginDao {

	/**
	 * �����û����������ȡ�û���Ϣ
	 * @param uname	�û���
	 * @param pwd	����
	 * @return User
	 */
	User checkLoginDao(String uname,String pwd);

	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return User
	 */
	User checkIdDao(String id);
	
}
