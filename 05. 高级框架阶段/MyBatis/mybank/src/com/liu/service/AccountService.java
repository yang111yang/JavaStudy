package com.liu.service;

import java.io.IOException;

import com.liu.pojo.Account;

public interface AccountService {
	
	/**
	 * �ʺź����벻ƥ��״̬��
	 */
	int ACCOUNT_PASSWORD_NOT_MATCH=1;
	/**
	 * ����
	 */
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;
	/**
	 * �˻�������ƥ��
	 */
	int ACCOUNT_NAME_NOT_MATCH=3;
	/**
	 * ת��ʧ��
	 */
	int ERROR=4;
	/**
	 * ת�˳ɹ�
	 */
	int SUCCESS=5;
	
	/**
	 * ת��
	 * @param accIn
	 * @param accOut
	 * @return
	 * @throws IOException 
	 */
	int transfer(Account accIn,Account accOut) throws IOException;

}
