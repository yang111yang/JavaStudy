package com.liujy.io2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	������	DataOutputStream DataInputStream
 * 1.��д����ȡ
 * 2.д��Ͷ�ȡ������Ҫ����һ��
 * @author ������
 *
 */
public class DataStreamTest {
	public static void main(String[] args) throws Exception {
		// д��Ķ������ļ�
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("obj.ser"));
		dos.writeUTF("һ��˪��ʮ����");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.writeDouble(1.00);
		dos.flush();
		dos.close();
		// ��ȡ
		DataInputStream dis = new DataInputStream(new FileInputStream("obj.ser"));
		String str = dis.readUTF();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		double d = dis.readDouble();
		System.out.println(flag);
		dis.close();
	}
	
	public static void test() throws Exception {
		// д��Ķ������ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF("һ��˪��ʮ����");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.writeDouble(1.00);
		dos.flush();
		dos.close();
		// ��ȡ
		byte[] datas = baos.toByteArray();
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(datas));
		String str = dis.readUTF();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		double d = dis.readDouble();
		System.out.println(flag);
		dis.close();
	}
}
