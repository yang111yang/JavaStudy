package com.liujy.file;

import java.io.UnsupportedEncodingException;

/**
 * 	���룺�ַ���-->�ֽ�
 * @author ������
 *
 */
public class ContentEncode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "��������ʹ��a";
		byte[] datas = str.getBytes();
		System.out.println(datas.length);
		
		datas = str.getBytes("UTF-8");
		System.out.println(datas.length);
	}
	
}
