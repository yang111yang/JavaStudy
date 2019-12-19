package com.liujy.io2;
/**
 * ʵ�ַŴ����������ķŴ���
 * @author ������
 *
 */
public class DecorateTest01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		Amplifier amplifier = new Amplifier(p);
		amplifier.say();
	}
}

interface Speak{
	void say();
}

class Person implements Speak{
	//���ԣ��˵������ķֱ�
	private int voice = 10;

	@Override
	public void say() {
		System.out.println("�˵�����Ϊ��"+this.getVoice());
		
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
}

class Amplifier implements Speak{
	
	private Person p;

	public Amplifier(Person p) {
		this.p = p;
	}

	@Override
	public void say() {
		System.out.println("�˵�����Ϊ��"+this.p.getVoice()*100);
		System.out.println("����.......");
	}
	
}
