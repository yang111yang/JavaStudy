package com.liu.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射获取注解信息
 * @author liujy
 *
 */
@SuppressWarnings("all")
public class Demo {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.liu.annotation.Student");
			// 获取所有的类的注解
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			
			// 获取类的注解
			Table a = (Table) clazz.getAnnotation(Table.class);
			System.out.println(a.value());
			
			// 获取属性的注解
			Field f = clazz.getDeclaredField("sname");
			StudentFiled studentFiled = f.getAnnotation(StudentFiled.class);
			System.out.println(studentFiled.columnName()+"--"+studentFiled.type()+"--"+studentFiled.len());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
