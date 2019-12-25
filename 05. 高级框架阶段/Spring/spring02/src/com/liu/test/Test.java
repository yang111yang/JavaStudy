package com.liu.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.liu.pojo.People;
import com.liu.service.PeopleService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		PeopleService peopleService = ac.getBean("peopleService",PeopleService.class);
		List<People> list = peopleService.showPeople();
		System.out.println(list);
	}
	
}
