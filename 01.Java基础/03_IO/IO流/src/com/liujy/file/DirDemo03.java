package com.liujy.file;
/**
 * 	�ݹ�
 * 	�ݹ�ͷ���жϺ�ʱ�����ݹ�
 * 	�ݹ��壺���õݹ鷽������
 * @author ������
 *
 */
public class DirDemo03 {
	
	public static void main(String[] args) {
		printTen(1);
	}
	
	public static void printTen(int i) {
		if (i > 10) { // �ݹ�ͷ
			return;
		}
		
		System.out.println(i);
		printTen(i + 1); // �ݹ���
	}

}
