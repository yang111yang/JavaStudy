package com.liu.advice;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.liu.pojo.User;

public class AfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Logger logger = Logger.getLogger(AfterAdvice.class);
		String username = (String) arg2[0];
		List<User> list = (List<User>) arg0;
		if (list.size()>0) {
			logger.info(username+"µÇÂ¼³É¹¦");
		} else {
			logger.info(username+"µÇÂ¼Ê§°Ü");
		}
	}

}
