package com.liu.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrow implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("ִ���쳣֪ͨͨ��-schema-base��ʽ");
	}
	
}
