package com.liujy.thread;
/**
 * 	Lambda���ʽ���Ƶ����в���,�з���ֵ�����д��룩
 * @author ������
 *
 */
public class LambdaTest03 {
	
	public static void main(String[] args) {
		// �ⲿ��
		ILove1 love = null;
		
		// lambda�򻯣�ֻ����С����
		love = (a,b)-> {
				System.out.println("i Love lambda" + (a+b));
				return a+b;
			};
		love.lambda(1,2);
		
	}
	
}

interface ILove1 {
	int lambda(int a,int b);
}

