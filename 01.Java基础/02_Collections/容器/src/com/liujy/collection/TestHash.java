package com.liujy.collection;

public class TestHash {

	 public static void main(String[] args) {
	        int h = 25860399;
	        int length = 16;//lengthΪ2����������,��h&(length-1)�൱�ڶ�lengthȡģ
	        myHash(h, length);
	        
	        String a = "123";
	        System.out.println(a.hashCode());
	        
	    }
	    /**
	     * @param h  ��������
	     * @param length ���ȱ���Ϊ2��������
	     * @return
	     */
	    public static  int myHash(int h,int length){
	        System.out.println(h&(length-1));
	        //lengthΪ2������������£���ȡ���ֵһ��
	        System.out.println(h%length);//ȡ����
	        return h&(length-1);
	    }
	    
}
