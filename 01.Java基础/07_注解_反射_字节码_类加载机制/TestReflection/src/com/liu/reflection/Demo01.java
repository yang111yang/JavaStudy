package com.liu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.liu.reflection.user.User;

/**
 * 通过反射获取类的名称、类的属性、方法和构造器
 * @author liujy
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		String path = "com.liu.reflection.user.User";
		try {
			Class<User> clazz = (Class<User>) Class.forName(path);
			
			// 获取类名称
			System.out.println(clazz.getName()); // com.liu.reflection.user.User
			System.out.println(clazz.getSimpleName()); // User
			
			// 获取类的属性
//			Field[] fields = clazz.getFields(); // 只能获取public修饰的属性
			Field[] fields = clazz.getDeclaredFields();
			Field f = clazz.getDeclaredField("uname");
			for (Field field : fields) {
				System.out.println("属性："+field);
			}
			
			// 获取类的方法
//			Method[] methods = clazz.getMethods(); // 只能获取public修饰的方法
			Method[] methods = clazz.getDeclaredMethods();
			Method method = clazz.getDeclaredMethod("setUname", String.class);// 后一个可变参数是为了防止重载的方法
			for (Method m : methods) {
				System.out.println("方法：" + m);
			}
			
			// 获取类的构造器
			Constructor<User>[] constructors = (Constructor<User>[]) clazz.getDeclaredConstructors();
			Constructor<User> constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
			for (Constructor<User> c : constructors) {
				System.out.println("构造方法："+c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
