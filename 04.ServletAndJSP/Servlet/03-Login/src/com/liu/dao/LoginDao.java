package com.liu.dao;

import com.liu.bean.User;

public interface LoginDao {

	/**
	 * �����ݿ��в�ѯָ���û�������
	 * @param uname
	 * @param pwd
	 * @return
	 */
	User checkLoginDao(String uname, String pwd);

	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	User checkIdDao(String id);
	
}
