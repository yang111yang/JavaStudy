package com.liu.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
//		System.out.println("切点方法的方法对象:"+arg0);
//		if (arg1.length>0) {
//			System.out.println("切点方法的方法参数:"+arg1[0]);
//		}
//		System.out.println("切点所在的对象："+arg2);
		System.out.println("我是前置通知");
		
	}
	
}
