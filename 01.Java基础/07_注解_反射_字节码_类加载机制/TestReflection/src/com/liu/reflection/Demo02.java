package com.liu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.liu.reflection.user.User;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 * @author liujy
 *
 */
public class Demo02 {
	
	public static void main(String[] args) {
		String path = "com.liu.reflection.user.User";
		try {
			Class<User> clazz = (Class<User>) Class.forName(path);
			
			// 操作类的属性
			Field f = clazz.getDeclaredField("uname");
			User u1 = clazz.getConstructor().newInstance();
			f.setAccessible(true); // 设置私有的属性可以进行操作
			f.set(u1, "laoliu");
			System.out.println(u1.getUname());
			
			// 操作类的方法
			Method method = clazz.getDeclaredMethod("setUname", String.class);// 后一个可变参数是为了防止重载的方法
			User u2 = clazz.getConstructor().newInstance();
			method.invoke(u2, "laowang");
			System.out.println(u2.getUname());
			
			// 操作类的构造器
			Constructor<User> constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
			User u3 = constructor.newInstance(1001, 28, "laozhang");
			System.out.println(u3.getId()+"-->"+u3.getAge()+"-->"+u3.getUname());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
