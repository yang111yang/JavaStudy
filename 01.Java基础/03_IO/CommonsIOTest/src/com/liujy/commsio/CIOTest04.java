package com.liujy.commsio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 	文件的写入
 * @author 刘建阳
 *
 */
public class CIOTest04 {

	public static void main(String[] args) throws IOException {
		// 文件的写入
		
		FileUtils.write(new File("happy.txt"), "学习强国\r\n","GBK");
		List<String> datas = new ArrayList<String>();
		datas.add("我在马路边");
		datas.add("捡到一分钱");
		datas.add("交给了班主任");
		FileUtils.writeLines(new File("happy.txt"), datas,"*********",true);
		
		
	}
	
}
