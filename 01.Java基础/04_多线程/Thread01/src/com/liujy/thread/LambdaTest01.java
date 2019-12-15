package com.liujy.thread;
/**
 * 	Lambda表达式的推导（无参，一多行代码）
 * @author 刘建阳
 *
 */
public class LambdaTest01 {
	
	static class Like2 implements ILike{
		public void lambda() {
			System.out.println("i like lambda2");
			
		}
	}

	public static void main(String[] args) {
		// 外部类
		ILike like = new Like1();
		like.lambda();
		
		// 静态内部类
		like = new Like2();
		like.lambda();
		
		// 局部内部类
		class Like3 implements ILike{
			public void lambda() {
				System.out.println("i like lambda3");
				
			}
		}
		like = new Like3();
		like.lambda();
		
		// 匿名内部类
		like = new ILike() {
			@Override
			public void lambda() {
				System.out.println("i like lambda4");
			}
		};
		like.lambda();
		
		// lambda简化，只保留小括号
		like = ()-> {
				System.out.println("i like lambda5");
			};
		like.lambda();
		
		// lambda简化，如果花括号中的代码只有一行，可省略花括号
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