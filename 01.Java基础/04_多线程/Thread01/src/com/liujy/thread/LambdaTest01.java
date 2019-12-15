package com.liujy.thread;
/**
 * 	Lambda���ʽ���Ƶ����޲Σ�һ���д��룩
 * @author ������
 *
 */
public class LambdaTest01 {
	
	static class Like2 implements ILike{
		public void lambda() {
			System.out.println("i like lambda2");
			
		}
	}

	public static void main(String[] args) {
		// �ⲿ��
		ILike like = new Like1();
		like.lambda();
		
		// ��̬�ڲ���
		like = new Like2();
		like.lambda();
		
		// �ֲ��ڲ���
		class Like3 implements ILike{
			public void lambda() {
				System.out.println("i like lambda3");
				
			}
		}
		like = new Like3();
		like.lambda();
		
		// �����ڲ���
		like = new ILike() {
			@Override
			public void lambda() {
				System.out.println("i like lambda4");
			}
		};
		like.lambda();
		
		// lambda�򻯣�ֻ����С����
		like = ()-> {
				System.out.println("i like lambda5");
			};
		like.lambda();
		
		// lambda�򻯣�����������еĴ���ֻ��һ�У���ʡ�Ի�����
		like = ()->System.out.println("i like lambda6");
		like.lambda();
		
	}
	
}

interface ILike {
	void lambda();
}

class Like1 implements ILike{

	@Override
	public void lambda() {
		System.out.println("i like lambda1");
		
	}
	
}