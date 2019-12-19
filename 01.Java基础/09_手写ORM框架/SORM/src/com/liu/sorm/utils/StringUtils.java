package com.liu.sorm.utils;

/**
 * 封装字符串的常用操作
 * @author liujy
 *
 */
public class StringUtils {
	
	/**
	 * 将字符串的首字母变为大写
	 * @param str	要修改首字母的字符串
	 * @return	首字母大写的字符串
	 */
	public static String convertFirstChar2UpperCase(String str) {
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}

}
