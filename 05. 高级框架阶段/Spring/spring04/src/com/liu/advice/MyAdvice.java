package com.liu.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	
//	public void mybefore() {
//		System.out.println("ǰ��֪ͨ");
//	}
	
	public void myafter1() {
		System.out.println("����֪ͨ1");
	}
	
	public void myafter2() {
		System.out.println("����֪ͨ2");
	}
	
	public void mythrow() {
		System.out.println("�쳣֪ͨ");
	}
	
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("ִ�л���");
		System.out.println("����-ǰ��");
		Object result = p.proceed();
		System.out.println("����-����");
		return result;
	}
}
