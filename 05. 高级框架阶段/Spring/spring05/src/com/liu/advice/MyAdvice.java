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
		System.out.println("前置通知");
	}
	@After("com.liu.test.Demo.demo1()")
	public void myafter1() {
		System.out.println("后置通知1");
	}
	
	public void myafter2() {
		System.out.println("后置通知2");
	}
	@AfterThrowing("com.liu.test.Demo.demo1()")
	public void mythrow() {
		System.out.println("异常通知");
	}
	@Around("com.liu.test.Demo.demo1()")
	public Object myarround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("执行环绕");
		System.out.println("环绕-前置");
		Object result = p.proceed();
		System.out.println("环绕-后置");
		return result;
	}
}
