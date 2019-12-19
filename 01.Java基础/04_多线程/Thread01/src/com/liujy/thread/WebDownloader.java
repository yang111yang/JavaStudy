package com.liujy.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 	图片下载
 * @author 刘建阳
 *
 */
public class WebDownloader {
	
	public void download(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("文件路径不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件下载失败");
		}
	}

}
