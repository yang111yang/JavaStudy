package com.liujy.io2;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 	��ӡ��
 * 	PrintStream
 * @author ������
 *
 */
public class PrintTest01 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.append("��ӡ��");
		ps.println();
		
		ps = new PrintStream(new FileOutputStream("print.txt"), true);
		ps.println("��ӡ��");
		ps.println(true);
		
		System.setOut(ps);
		System.out.println("change");
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true));
		System.out.println("i am backing");
		
	}

}
