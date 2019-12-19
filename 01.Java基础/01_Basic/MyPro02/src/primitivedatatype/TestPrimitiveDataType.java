package primitivedatatype;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

/**
 * 	���Ի�����������
 * @author ������
 *
 */
public class TestPrimitiveDataType {

	public static void main(String[] args) {
		// �������ͱ���
		int a = 15;	
		int b = 015; // ��0��ͷ���ǰ˽���
		int c = 0x15; // ��0x��ͷ����16����
		int d = 0b1101; // ��0b��ͷ���Ƕ�����
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		byte age = 30;
		short salary = 30000;
		int population = 2000000000;
		long globalPopulation = 7400000000L;
		
		// ���Ը����ͱ���
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
	 *  ����ʹ��BigDecimal���㸡���ͱ���
	 *  �������������������ֲ��ܾ�ȷ��ʾ�������Ҫ���в������������ľ�ȷ���ּ��㣬��Ҫʹ��BigDecimal��
	 */
	@Test
	public void testBigDecimal() {
		
		BigDecimal bd = new BigDecimal(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 ��ȥ0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 ��ȥ0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 ��ȥ0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 ��ȥ0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 ��ȥ0.1
		bd = bd.subtract(BigDecimal.valueOf(0.1)); // 1.0 ��ȥ0.1
		System.out.println(bd); // 0.4
		System.out.println(1.0-0.1-0.1-0.1-0.1-0.1-0.1); // 0.40000000000000013
		
	}
	
	/**
	 * �����ַ��ͱ���
	 */
	@Test
	public void testChar() {
		char a = '��';
		System.out.println(a);
		
		char b = '\u0061';
		System.out.println(b);
		
		String d = "abc";
		char[] array = d.toCharArray();
		System.out.println(array[0]);
	}
	
	
}
