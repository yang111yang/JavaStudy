package com.liu.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 请求信息处理
 * @author liujy
 *
 */
public class Request01 {

	private String requestInfo; //协议信息
	private String requestMethod; // 请求方式
	private String requestUrl; // url
	private String requestPara; // 请求参数
	private final String CRLF = "\r\n";
	
	public Request01(Socket client) throws IOException {
		this(client.getInputStream());
	}
	
	public Request01(InputStream is) {
		byte[] datas = new byte[1024*1024];
		int len;
		try {
			len = is.read(datas);
			requestInfo = new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 分解字符串
		parseRequestInfo();
	}
	
	public void parseRequestInfo() {
		this.requestMethod = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase().trim();
		int startIdx = this.requestInfo.indexOf("/") + 1;
		int endIdx = this.requestInfo.indexOf("HTTP/");
		this.requestUrl = this.requestInfo.substring(startIdx, endIdx);
		int queryIdx = this.requestUrl.indexOf("?");
		if (queryIdx > 0) {
			String[] split = this.requestUrl.split("\\?");
			this.requestUrl = split[0];
			this.requestPara = split[1].trim();
		}
		if (this.requestMethod.equals("post")) {
			String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if (this.requestPara == null) {
				this.requestPara = qStr;
			} else {
				this.requestPara += "&" + qStr;
			}
		}
		System.out.println(this.requestMethod+"-->"+this.requestUrl+"-->"+this.requestPara);
	}
}
