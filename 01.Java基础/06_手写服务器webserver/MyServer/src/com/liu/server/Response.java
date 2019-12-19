package com.liu.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 响应信息
 * @author liujy
 *
 */
public class Response {
	
	private StringBuilder resInfo;
	private StringBuilder content;
	private final String BLANK = " ";
	private final String CRLF = "\r\n";
	private BufferedWriter bw;
	private int len;
	
	public Response() {
		resInfo = new StringBuilder();
		content = new StringBuilder();
	}
	
	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			resInfo = null;
		}
	}
	
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	/** 添加内容 */
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;
	}
	
	/** 添加带换行的内容 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info+CRLF).getBytes().length;
		return this;
	}
	
	private void createResInfo(int code) {
		String status = "";
		switch (code) {
		case 200:
			status = "OK";
			break;
		case 404:
			status = "NOT FOUND";
			break;
		case 500:
			status = "SERVER ERROR";
			break;

		default:
			break;
		}
		resInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK).append(status).append(CRLF);
		resInfo.append("Date:").append(new Date()).append(CRLF);
		resInfo.append("Server:shsxt Server/0.0.1;charset=GBK").append(CRLF);
		resInfo.append("Content-type:text/html").append(CRLF);
		resInfo.append("Content-length:").append(len).append(CRLF);
		resInfo.append(CRLF);
	}
	
	public void pushToBrowser(int code) {
		createResInfo(code);
		resInfo.append(content);
		try {
			bw.write(resInfo.toString());
			bw.write(content.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
