package com.liujy.io2;
/**
 * 实现放大器对声音的放大功能
 * @author 刘建阳
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
	//属性，人的声音的分贝
	private int voice = 10;

	@Override
	public void say() {
		System.out.println("人的声音为："+this.getVoice());
		
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
		System.out.println("人的声音为："+this.p.getVoice()*100);
		System.out.println("噪音.......");
	}
	
}
