package com.liu.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
//		System.out.println("�е㷽���ķ�������:"+arg0);
//		if (arg1.length>0) {
//			System.out.println("�е㷽���ķ�������:"+arg1[0]);
//		}
//		System.out.println("�е����ڵĶ���"+arg2);
		System.out.println("����ǰ��֪ͨ");
		
	}
	
}
