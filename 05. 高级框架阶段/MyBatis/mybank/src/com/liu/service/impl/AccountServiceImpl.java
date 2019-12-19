package com.liu.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.liu.pojo.Account;
import com.liu.pojo.Log;
import com.liu.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Account accInObj = session.selectOne("com.liu.mapper.AccountMapper.selByAccNoAndPassword", accIn);
		//�ж�ת���˺ź������Ƿ�ƥ��
		int code = 0;
		if (accInObj != null) {
			//�ж�ת���˻�����Ƿ����ת�˽��
			if (accInObj.getBalance()>=accIn.getBalance()) {
				//�ж�ת���˻����˺źͻ����Ƿ�һ��
				Account accOutObj = session.selectOne("com.liu.mapper.AccountMapper.selByAccNoAndAccName", accOut);
				if (accOutObj != null) {
					accInObj.setBalance(accInObj.getBalance()-accIn.getBalance());
					accOutObj.setBalance(accOutObj.getBalance()+accOut.getBalance());
					int index = session.update("com.liu.mapper.AccountMapper.updateBalance",accInObj);
					index += session.update("com.liu.mapper.AccountMapper.updateBalance",accOutObj);
					if (index == 2) {//ת�˳ɹ�
						//��¼��־
						//��־���¼
						Log log = new Log();
						log.setAccIn(accInObj.getAccNo());
						log.setAccOut(accOutObj.getAccNo());
						log.setMoney(accIn.getBalance());
						session.insert("com.liu.mapper.LogMapper.insLog",log);
						//��־�ļ���¼
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccIn()+"��"+log.getAccOut()+"ת��"+log.getMoney()+"��Ǯ");
						session.commit();
						session.close();
						code=SUCCESS;
					} else {//ת��ʧ��
						//�ع�����
						session.rollback();
						session.close();
						code=ERROR;
					}
				} else {
					//�˻�������ƥ��
					code = ACCOUNT_NAME_NOT_MATCH;
				}
			} else {
				//����
				code = ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		} else {
			//�ʺź����벻ƥ��״̬��
			code=ACCOUNT_PASSWORD_NOT_MATCH;
		}
		return code;
	}

}
