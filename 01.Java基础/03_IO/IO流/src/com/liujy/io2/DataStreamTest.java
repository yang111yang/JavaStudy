package com.liujy.io2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	数据流	DataOutputStream DataInputStream
 * 1.先写入后读取
 * 2.写入和读取的数据要保持一致
 * @author 刘建阳
 *
 */
public class DataStreamTest {
	public static void main(String[] args) throws Exception {
		// 写入的对象是文件
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("obj.ser"));
		dos.writeUTF("一剑霜寒十四州");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.writeDouble(1.00);
		dos.flush();
		dos.close();
		// 读取
		DataInputStream dis = new DataInputStream(new FileInputStream("obj.ser"));
		String str = dis.readUTF();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		double d = dis.readDouble();
		System.out.println(flag);
		dis.close();
	}
	
	public static void test() throws Exception {
		// 写入的对象是字节数组
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF("一剑霜寒十四州");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.writeDouble(1.00);
		dos.flush();
		dos.close();
		// 读取
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
