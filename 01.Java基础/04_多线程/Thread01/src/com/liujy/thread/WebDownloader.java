package com.liujy.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 	ͼƬ����
 * @author ������
 *
 */
public class WebDownloader {
	
	public void download(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("�ļ�·��������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�����ʧ��");
		}
	}

}
