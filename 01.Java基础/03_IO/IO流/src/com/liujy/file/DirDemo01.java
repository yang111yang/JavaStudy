package com.liujy.file;

import java.io.File;

/**
 * 	����Ŀ¼
 * 	1��mkdir() ��һ��Ŀ¼�������
 * 	2��mkdirs()	�ϼ�Ŀ¼���Բ����ڣ��������ǻ��Զ�����
 * @author ������
 *
 */
public class DirDemo01 {
	
	public static void main(String[] args) {
		// mkdir()
		File dir = new File("E:/workspace/SXT/IO��/dir/test");
		System.out.println(dir.mkdir()); // false
		
		dir = new File("E:/workspace/SXT/IO��/dir");
		System.out.println(dir.mkdir()); // true
		dir.delete();
		
		
		// mkdirs()
		dir = new File("E:/workspace/SXT/IO��/dir/test");
		System.out.println(dir.mkdirs()); // true
	}

}
