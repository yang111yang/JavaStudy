package com.liujy.collection;

import java.util.List;
import java.util.Vector;
/**
 * 	测试Vector
 * @author 刘建阳
 *
 */
public class TestVector {
	public static void main(String[] args) {
		List<String> list = new Vector<>();
		/*
		 *	Vector的底层实现和ArrayList是基本相同的，因为Vector是线程安全的，
		 *	所以Vector源码中的方法大部分增加了synchronized关键字 。
		 */
	}
}
