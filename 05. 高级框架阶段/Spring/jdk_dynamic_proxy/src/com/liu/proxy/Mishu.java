package com.liu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Mishu implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("ԤԼʱ��");
		Object result = method.invoke(new Laozong(), args);
		System.out.println("��ע");
		return result;
	}
	
	
	
}
