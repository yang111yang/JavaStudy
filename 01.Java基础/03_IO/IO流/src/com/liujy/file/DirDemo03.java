package com.liujy.file;
/**
 * 	递归
 * 	递归头：判断何时结束递归
 * 	递归体：调用递归方法本身
 * @author 刘建阳
 *
 */
public class DirDemo03 {
	
	public static void main(String[] args) {
		printTen(1);
	}
	
	public static void printTen(int i) {
		if (i > 10) { // 递归头
			return;
		}
		
		System.out.println(i);
		printTen(i + 1); // 递归体
	}

}
