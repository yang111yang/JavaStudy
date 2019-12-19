package com.liujy.file;

import java.io.UnsupportedEncodingException;

/**
 * 	解码：字节-->字符串
 * @author 刘建阳
 *
 */
public class ContentDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "性命生命使命a";
		byte[] datas = str.getBytes();
		System.out.println(datas.length);
		
		String msg = new String(datas);
		System.out.println(msg);
		// 乱码的两种原因
		// 1）编码字符集不统一
		msg = new String(datas, 0, datas.length, "utf-8");
		System.out.println(msg);
		// 2）字节数不够
		msg = new String(datas, 0, datas.length-2, "gbk");
		System.out.println(msg);
	}
	
}
