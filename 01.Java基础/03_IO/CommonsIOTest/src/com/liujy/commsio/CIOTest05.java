package com.liujy.commsio;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

/**
 * 	文件的拷贝
 * @author 刘建阳
 *
 */
public class CIOTest05 {

	public static void main(String[] args) throws IOException {
		// 复制文件到文件
		//FileUtils.copyFile(new File("io.jpg"), new File("io-copy.jpg"));
		
		// 复制文件到目录
		//FileUtils.copyFileToDirectory(new File("io.jpg"), new File("lib"));
		
		// 复制目录到另一个目录(为子目录)
		//FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		
		// 复制目录
//		FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		
		// 复制URL
//		String url = "https://pic2.zhimg.com/v2-7d01cab20858648cbf62333a7988e6d0_qhd.jpg";
//		FileUtils.copyURLToFile(new URL(url), new File("fj.jpg"));
		String msg = IOUtils.toString(new URL("http://www.163.com"), "GBK");
		System.out.println(msg);
	}
	
}
