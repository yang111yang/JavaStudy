package com.liu.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.liu.pojo.User;

public class BeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		Logger logger = Logger.getLogger(BeforeAdvice.class);
		String username = (String) arg1[0];
		logger.info(username+"ÔÚ"+new Date().toLocaleString()+"½øÐÐµÇÂ¼");
		
	}
	
	

}
