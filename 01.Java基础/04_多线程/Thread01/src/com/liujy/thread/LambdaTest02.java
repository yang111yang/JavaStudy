package com.liujy.thread;
/**
 * 	Lambda���ʽ���Ƶ����в���,�з���ֵ�����д��룩
 * @author ������
 *
 */
public class LambdaTest02 {
	
	static class Love2 implements ILove{
		public int lambda(int a) {
			System.out.println("i Love lambda" + a);
			return a;
		}
	}

	public static void main(String[] args) {
		// �ⲿ��
		ILove love = new Love1();
		love.lambda(1);
		
		// ��̬�ڲ���
		love = new Love2();
		love.lambda(2);
		
		// �ֲ��ڲ���
		class Love3 implements ILove{
			public int lambda(int a) {
				System.out.println("i Love lambda" + a);
				return a;
			}
		}
		love = new Love3();
		love.lambda(3);
		
		// �����ڲ���
		love = new ILove() {
			public int lambda(int a) {
				System.out.println("i Love lambda" + a);
				return a;
			}
		};
		love.lambda(4);
		
		// lambda�򻯣�ֻ����С����
		love = (a)-> {
				System.out.println("i Love lambda" + a);
				return a;
			};
		love.lambda(5);
		
		// lambda�򻯣���������еĲ���ֻ��һ��������ʡ��С����
		love = a->{
			System.out.println("i Love lambda"+ a);
			return a;
		};
		love.lambda(6);
		
	}
	
}

interface ILove {
	int lambda(int a);
}

class Love1 implements ILove{

	@Override
	public int lambda(int a) {
		System.out.println("i Love lambda" + a);
		return a;
	}
	
}