package com.liu.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Mishu implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("ԤԼʱ��");
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("��ע");
		return result;
	}
	
	
	
}
