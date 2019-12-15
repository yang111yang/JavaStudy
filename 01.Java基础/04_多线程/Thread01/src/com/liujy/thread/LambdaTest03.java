package com.liujy.thread;
/**
 * 	Lambda表达式的推导（有参数,有返回值，多行代码）
 * @author 刘建阳
 *
 */
public class LambdaTest03 {
	
	public static void main(String[] args) {
		// 外部类
		ILove1 love = null;
		
		// lambda简化，只保留小括号
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

