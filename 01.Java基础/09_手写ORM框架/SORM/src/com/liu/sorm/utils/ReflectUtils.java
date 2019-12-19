package com.liu.sorm.utils;

import java.lang.reflect.Method;

import com.liu.sorm.bean.TableInfo;

/**
 * 封装java文件操作
 * 
 * @author liujy
 *
 */
public class ReflectUtils {

	/**
	 * 使用反射调用指定属性的对象的get方法
	 * 
	 * @param obj       javabean对象
	 * @param fieldName 属性名
	 * @return 通过get方法获取属性的值
	 */
	public static Object invokeGet(Object obj, String fieldName) {
		try {
			Class clazz = obj.getClass();
			Method getMethod = clazz.getDeclaredMethod("get" + StringUtils.convertFirstChar2UpperCase(fieldName), null);
			return getMethod.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 使用反射调用指定属性的对象的set方法
	 * 
	 * @param obj        javabean对象
	 * @param fieldName  属性名
	 * @param fieldValue 属性的值
	 */
	public static void invokeSet(Object obj, String fieldName, Object fieldValue) {
		try {
			if (fieldValue != null) {
				Method setMethod = obj.getClass().getMethod("set" + StringUtils.convertFirstChar2UpperCase(fieldName),
						fieldValue.getClass());
				setMethod.invoke(obj, fieldValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
