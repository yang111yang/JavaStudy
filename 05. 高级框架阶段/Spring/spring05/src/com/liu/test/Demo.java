package com.liu.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Pointcut("execution(* com.liu.test.Demo.demo1())")
	public void demo1() {
		System.out.println("Œ“ «demo1");
//		int a = 5/0;
	}
}
