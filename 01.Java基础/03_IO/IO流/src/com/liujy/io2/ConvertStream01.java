package com.liujy.io2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 	ת����	InputStreamReader OutputStreamWriter
 * 1.���ַ�������ʽ�����ֽ��������ı���
 * 2.ָ���ַ���
 * @author ������
 *
 */
public class ConvertStream01 {
	
	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
			String msg = "";
			while (!msg.equals("exit")) {
				msg = reader.readLine();
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
		} catch (Exception e) {
			
		}
	}

}
