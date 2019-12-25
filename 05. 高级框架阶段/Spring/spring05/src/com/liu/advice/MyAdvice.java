package com.liu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAdvice {
	@Before("com.liu.test.Demo.demo1()")
	public void mybefore() {
		System.out.println("ǰ��֪ͨ");
	}
	@After("com.liu.test.Demo.demo1()")
	public void myafter1() {
		System.out.println("����֪ͨ1");
	}
	
	public void myafter2() {
		System.out.println("����֪ͨ2");
	}
	@AfterThrowing("com.liu.test.Demo.demo1()")
	public void mythrow() {
		System.out.println("�쳣֪ͨ");
	}
	@Around("com.liu.test.Demo.demo1()")
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("ִ�л���");
		System.out.println("����-ǰ��");
		Object result = p.proceed();
		System.out.println("����-����");
		return result;
	}
}
