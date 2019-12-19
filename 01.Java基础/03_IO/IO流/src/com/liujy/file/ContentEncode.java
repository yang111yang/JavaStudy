package com.liujy.file;

import java.io.UnsupportedEncodingException;

/**
 * 	±àÂë£º×Ö·û´®-->×Ö½Ú
 * @author Áõ½¨Ñô
 *
 */
public class ContentEncode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "ĞÔÃüÉúÃüÊ¹Ãüa";
		byte[] datas = str.getBytes();
		System.out.println(datas.length);
		
		datas = str.getBytes("UTF-8");
		System.out.println(datas.length);
	}
	
}
