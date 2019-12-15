package com.liu.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ʹ�÷����ȡע����Ϣ
 * @author liujy
 *
 */
@SuppressWarnings("all")
public class Demo {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.liu.annotation.Student");
			// ��ȡ���е����ע��
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			
			// ��ȡ���ע��
			Table a = (Table) clazz.getAnnotation(Table.class);
			System.out.println(a.value());
			
			// ��ȡ���Ե�ע��
			Field f = clazz.getDeclaredField("sname");
			StudentFiled studentFiled = f.getAnnotation(StudentFiled.class);
			System.out.println(studentFiled.columnName()+"--"+studentFiled.type()+"--"+studentFiled.len());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
