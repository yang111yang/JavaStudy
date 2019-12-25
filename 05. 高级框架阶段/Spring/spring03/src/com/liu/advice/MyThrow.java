package com.liu.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrow implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("执行异常通知通过-schema-base方式");
	}
	
}
