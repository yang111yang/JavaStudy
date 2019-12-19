package com.liujy.io2;

/**
 * װ����ģʽ
 * ģ�⿧��
 * 1.�����������Ҫװ�εĳ�����󣨽ӿڻ�����ࣩ
 * 2.�����������Ҫװ�εĶ���
 * 3.����װ���ࣺ�����˶Գ�������������Լ�װ���߹��еķ���
 * 4.����װ���ࣺ��װ�εĶ���
 * @author ������
 *
 */
public class DecorateTest02 {
	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		System.out.println(coffee.info()+coffee.cost());
		
		Milk milk = new Milk(coffee); // װ��
		System.out.println(milk.info()+milk.cost());
		
		Suger suger = new Suger(milk); // װ��
		System.out.println(suger.info()+suger.cost());
	}
}

// �������
interface Drink {
	double cost(); // ����
	String info(); // ˵��
}

// �������
class Coffee implements Drink {
	
	// ����
	private String name = "ԭζ����";

	@Override
	public double cost() {
		return 20;
	}

	@Override
	public String info() {
		return name;
	}
	
}

// ����װ����
abstract class Decorate implements Drink {
	
	private Drink drink; // ���ó����������
	
	public Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
	
}

// ����װ����
class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
	}

	@Override
	public double cost() {
		return super.cost()*4;
	}

	@Override
	public String info() {
		return super.info()+"������ţ��";
	}
	
}

// ����װ����
class Suger extends Decorate {

	public Suger(Drink drink) {
		super(drink);
	}

	@Override
	public double cost() {
		return super.cost()*2;
	}

	@Override
	public String info() {
		return super.info()+"��������";
	}
	
}