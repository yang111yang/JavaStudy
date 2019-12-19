package operator;

import org.junit.jupiter.api.Test;

public class TestOperator {
	
	/**
	 * 测试逻辑运算符
	 */
	@Test
	public void testLogicOperator() {
		// 异或^运算符：先把a和b转换成二进制，然后判断，如果相同出0，不同出1
		int a = 7;
		int b = 4;
		System.out.println(a^b);
		/*
		 * 00000000 00000000 00000000 00000100	4
		 * 00000000 00000000 00000000 00000111  7
		 * 00000000 00000000 00000000 00000011  3
		 * 00000000 00000000 00000000 00001100	12
		 */
	}
	
	/**
	 * 测试位运算符
	 */
	@Test
	public void testBitOperator() {
		
		int a = 3;
		System.out.println(a << 3);
		System.out.println(~a); // 取反
	}

}
