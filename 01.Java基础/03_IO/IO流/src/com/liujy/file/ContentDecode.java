package com.liujy.file;

import java.io.UnsupportedEncodingException;

/**
 * 	���룺�ֽ�-->�ַ���
 * @author ������
 *
 */
public class ContentDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "��������ʹ��a";
		byte[] datas = str.getBytes();
		System.out.println(datas.length);
		
		String msg = new String(datas);
		System.out.println(msg);
		// ���������ԭ��
		// 1�������ַ�����ͳһ
		msg = new String(datas, 0, datas.length, "utf-8");
		System.out.println(msg);
		// 2���ֽ�������
		msg = new String(datas, 0, datas.length-2, "gbk");
		System.out.println(msg);
	}
	
}
