package com.liu.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyArround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("����-ǰ��");
		Object result = arg0.proceed();//���У������е㷽ʽ
		System.out.println("����-����");
		return result;
	}
	
	
	
}
