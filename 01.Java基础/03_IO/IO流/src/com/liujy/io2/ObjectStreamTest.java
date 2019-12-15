package com.liujy.io2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	������	ObjectOutputStream ObjectInputStream
 * 1.��д����ȡ
 * 2.д��Ͷ�ȡ������Ҫ����һ��
 * @author ������
 *
 */
public class ObjectStreamTest {
	public static void main(String[] args) throws Exception {
		// д��Ķ������ļ�
		ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("obj.ser"));
		dos.writeUTF("һ��˪��ʮ����");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.writeDouble(1.00);
		dos.writeObject("��ɽ���ƹ�");
		dos.writeObject(new Date());
		dos.writeObject(new Employee("�����",100.00));
		dos.flush();
		dos.close();
		// ��ȡ
		ObjectInputStream dis = new ObjectInputStream(new FileInputStream("obj.ser"));
		String str = dis.readUTF();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		double d = dis.readDouble();
		System.out.println(flag);
		Object strObj = dis.readObject();
		Object date = dis.readObject();
		Object employee = dis.readObject();
		if (strObj instanceof String) {
			String str1 = (String) strObj;
			System.out.println(str1);
		}
		if (date instanceof Date) {
			Date dateObj = (Date) date;
			System.out.println(dateObj);
		}
		if (employee instanceof Employee) {
			Employee emp = (Employee) employee;
			System.out.println(emp.getName()+"--->"+emp.getSalary());
		}
		dis.close();
	}
	
}

@SuppressWarnings("serial")
class Employee implements Serializable {
	private String name;
	private double salary;
	
	public Employee() {
		super();
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}