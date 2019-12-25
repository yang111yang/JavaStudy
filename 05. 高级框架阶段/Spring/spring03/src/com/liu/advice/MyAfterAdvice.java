package com.liu.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("切点方法的返回值："+arg0);
		System.out.println("切点方法对象："+arg1);
		if (arg2.length>0) {
			System.out.println("切点方法的方法参数："+arg2[0]);
		}
		System.out.println("切点方法所在类的对象："+arg3);
		System.out.println("我是后置通知");
	}

}
