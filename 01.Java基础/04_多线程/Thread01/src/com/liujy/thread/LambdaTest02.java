package com.liujy.thread;
/**
 * 	Lambda表达式的推导（有参数,有返回值，多行代码）
 * @author 刘建阳
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
		// 外部类
		ILove love = new Love1();
		love.lambda(1);
		
		// 静态内部类
		love = new Love2();
		love.lambda(2);
		
		// 局部内部类
		class Love3 implements ILove{
			public int lambda(int a) {
				System.out.println("i Love lambda" + a);
				return a;
			}
		}
		love = new Love3();
		love.lambda(3);
		
		// 匿名内部类
		love = new ILove() {
			public int lambda(int a) {
				System.out.println("i Love lambda" + a);
				return a;
			}
		};
		love.lambda(4);
		
		// lambda简化，只保留小括号
		love = (a)-> {
				System.out.println("i Love lambda" + a);
				return a;
			};
		love.lambda(5);
		
		// lambda简化，如果方法中的参数只有一个，可以省略小括号
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