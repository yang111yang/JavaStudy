package com.net.loc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 网络爬虫的原理 + 模拟浏览器
 * @author 刘建阳
 *
 */
public class SpiderTest02 {

	public static void main(String[] args) throws Exception {
		// 1、URL
		URL url = new URL("https://www.dianping.com/");
		// 2、下载资源
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent" , "Mozilla/5.0 (Windows NT 10.0; …) Gecko/20100101 Firefox/68.0");
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream()));
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("dianping.html"),"UTF-8"))){
			String msg = null;
			while((msg = br.readLine())!=null) {
				bw.write(msg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 3、分析数据
		// 4、处理数据
	}

}
