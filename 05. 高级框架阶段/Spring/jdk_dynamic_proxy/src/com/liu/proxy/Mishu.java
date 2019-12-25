package com.liu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Mishu implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("预约时间");
		Object result = method.invoke(new Laozong(), args);
		System.out.println("备注");
		return result;
	}
	
	
	
}
