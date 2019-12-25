package com.liu.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	
//	public void mybefore() {
//		System.out.println("前置通知");
//	}
	
	public void myafter1() {
		System.out.println("后置通知1");
	}
	
	public void myafter2() {
		System.out.println("后置通知2");
	}
	
	public void mythrow() {
		System.out.println("异常通知");
	}
	
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("执行环绕");
		System.out.println("环绕-前置");
		Object result = p.proceed();
		System.out.println("环绕-后置");
		return result;
	}
}
