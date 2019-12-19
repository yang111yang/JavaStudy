package com.liu.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 响应信息的封装类
 * @author liujy
 *
 */
public class Response {
	
	private StringBuilder content;
	private StringBuilder headInfo;
	private int len;
	private final String BLANK = " ";
	private final String CRLF = "\r\n";
	private BufferedWriter bw;
	
	private Response() {
		content = new StringBuilder();
		headInfo = new StringBuilder();
	}
	
	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			headInfo = null;
		}
	}
	
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	// 动态添加内容
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;
	}
	
	// 动态添加内容（增加了换行）
	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info+CRLF).getBytes().length;
		return this;
	}

	// 构建响应信息
	public void createHeadInfo(int code) {
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
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK).append(status).append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
		headInfo.append("Content-type:text/html").append(CRLF);
		headInfo.append("Content-length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	}
	
	// 推送响应信息
	public void push(int code) throws IOException {
		if (headInfo == null) {
			code = 500;
		}
		createHeadInfo(code);
		bw.write(headInfo.toString());
		bw.write(content.toString());
		bw.flush();
	}
	
}
