package com.liu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liu.pojo.People;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		People people = ac.getBean("peo",People.class);
//		System.out.println(people);
//		String[] names = ac.getBeanDefinitionNames();
//		for (String string : names) {
//			System.out.println(string);
//		}
		People people = ac.getBean("peo7",People.class);
		System.out.println(people);
	}

}
