package com.liu.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 	反射： 把java类中的各种结构(方法、属性、构造器、类名)映射成一个个的Java对象
 * 1.获取Class对象
 * 	三种创建方式，推荐第三种方法：Class.forName("包名.类名");	好处是两个类可以解耦
 * 2.创建对象
 * @author liujy
 *
 */
public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// 获取Class对象
		// 第一种方式：new Iphone().getClass()
		Class cla = new Iphone().getClass();
		
		// 第二种方式：Iphone.class
		cla = Iphone.class;
		
		// 第三种方式：
		cla = Class.forName("com.liu.server.basic.Iphone");
		
		// 创建对象
//		Iphone iphone = (Iphone)cla.newInstance(); // 不建议使用，该方法在jdk1.9之前可以使用
		Iphone iphone = (Iphone)cla.getConstructor().newInstance(); // 建议使用构造器之后然后调用newInstance()
		
		System.out.println(iphone);

	}

}

class Iphone {

	public Iphone() {
	}
	
}