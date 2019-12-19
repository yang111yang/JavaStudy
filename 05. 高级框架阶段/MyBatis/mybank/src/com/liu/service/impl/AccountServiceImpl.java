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
		//判断转出账号和密码是否匹配
		int code = 0;
		if (accInObj != null) {
			//判断转出账户余额是否大于转账金额
			if (accInObj.getBalance()>=accIn.getBalance()) {
				//判断转入账户的账号和户名是否一致
				Account accOutObj = session.selectOne("com.liu.mapper.AccountMapper.selByAccNoAndAccName", accOut);
				if (accOutObj != null) {
					accInObj.setBalance(accInObj.getBalance()-accIn.getBalance());
					accOutObj.setBalance(accOutObj.getBalance()+accOut.getBalance());
					int index = session.update("com.liu.mapper.AccountMapper.updateBalance",accInObj);
					index += session.update("com.liu.mapper.AccountMapper.updateBalance",accOutObj);
					if (index == 2) {//转账成功
						//记录日志
						//日志表记录
						Log log = new Log();
						log.setAccIn(accInObj.getAccNo());
						log.setAccOut(accOutObj.getAccNo());
						log.setMoney(accIn.getBalance());
						session.insert("com.liu.mapper.LogMapper.insLog",log);
						//日志文件记录
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccIn()+"给"+log.getAccOut()+"转了"+log.getMoney()+"块钱");
						session.commit();
						session.close();
						code=SUCCESS;
					} else {//转账失败
						//回滚事务
						session.rollback();
						session.close();
						code=ERROR;
					}
				} else {
					//账户姓名不匹配
					code = ACCOUNT_NAME_NOT_MATCH;
				}
			} else {
				//余额不足
				code = ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		} else {
			//帐号和密码不匹配状态码
			code=ACCOUNT_PASSWORD_NOT_MATCH;
		}
		return code;
	}

}
