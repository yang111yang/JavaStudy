package com.liu.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("�е㷽���ķ���ֵ��"+arg0);
		System.out.println("�е㷽������"+arg1);
		if (arg2.length>0) {
			System.out.println("�е㷽���ķ���������"+arg2[0]);
		}
		System.out.println("�е㷽��������Ķ���"+arg3);
		System.out.println("���Ǻ���֪ͨ");
	}

}
