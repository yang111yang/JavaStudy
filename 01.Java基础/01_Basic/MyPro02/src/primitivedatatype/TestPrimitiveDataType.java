package primitivedatatype;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * 	测试基本数据类型
 * @author 刘建阳
 *
 */
public class TestPrimitiveDataType {

	public static void main(String[] args) {
		// 测试整型变量
		int a = 15;	
		int b = 015; // 以0开头的是八进制
		int c = 0x15; // 以0x开头的是16进制
		int d = 0b1101; // 以0b开头的是二进制
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		byte age = 30;
		short salary = 30000;
		int population = 2000000000;
		long globalPopulation = 7400000000L;
		
		// 测试浮点型变量
		float a1 = 0.1f;
		double b1 = 1.0/10;
		System.out.println(a1 == b1);
		System.out.println(BigDecimal.valueOf(b1));
		
		float d1 = 423432423f;
		float d2 = d1 + 1;
		if (d1 == d2) {
			System.out.println("d1==d2");
		} else {
			System.out.println("d1!=d2");
		}
		
		System.out.println(Float.MAX_VALUE+", "+Float.MIN_VALUE);
	}
	
	/*
	 *  测试使用BigDecimal计算浮点型变量
	 *  浮点数存在舍入误差，数字不能精确表示。如果需要进行不产生舍入误差的精确数字计算，需要使用BigDecimal类
	 */
	@Test
	public void testBigDecimal() {
		
		BigDecimal bd = new BigDecimal(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 减去0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 减去0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 减去0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 减去0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 减去0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 减去0.1
		System.out.println(bd); // 0.4
		System.out.println(1.0-0.1-0.1-0.1-0.1-0.1-0.1); // 0.40000000000000013
		
	}
	
	/**
	 * 测试字符型变量
	 */
	@Test
	public void testChar() {
		char a = '中';
		System.out.println(a);
		
		char b = '\u0061';
		System.out.println(b);
		
		String d = "abc";
		char[] array = d.toCharArray();
		System.out.println(array[0]);
	}
	
	
}
