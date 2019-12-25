package com.liu.proxy;

import java.lang.reflect.Proxy;

public class Women {
	public static void main(String[] args) {
		Gongneng gongneng = (Gongneng) Proxy.newProxyInstance(Women.class.getClassLoader(), new Class[] {Gongneng.class}, new Mishu());
		gongneng.chifan();
	}
}
