package com.liu.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求信息
 * @author liujy
 *
 */
public class Request {
	
	private final String CRLF = "\r\n";
	private Map<String, List<String>> paraMap;
	private String reqMethod;
	private String reqUrl;
	private String reqPara;
	
	public Request(Socket client) throws IOException {
		this(client.getInputStream());
	}
	
	public Request(InputStream is) {
		paraMap = new HashMap<String, List<String>>();
		byte[] flush = new byte[1024*1024];
		String reqInfo = "";
		try {
			reqInfo = new String(flush,0,is.read(flush));
			System.out.println(reqInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 解析字符串
		parseReqInfo(reqInfo);
	}
	
	/** 解析字符串 */
	private void parseReqInfo(String reqInfo) {
		reqMethod = reqInfo.substring(0, reqInfo.indexOf("/")).toLowerCase().trim();
		reqUrl = reqInfo.substring(reqInfo.indexOf("/")+1, reqInfo.indexOf("HTTP/")).trim();
		int queryIdx = reqInfo.indexOf("?");
		if (queryIdx > 0) {
			String[] reqStr = reqUrl.split("\\?");
			reqUrl = reqStr[0];
			reqPara = reqStr[1];
		}
		
		if (reqMethod.equals("post")) {
			String paraStr = reqInfo.substring(reqInfo.lastIndexOf(CRLF)).trim();
			if (reqPara == null) {
				reqPara = paraStr;
			} else {
				reqPara += "&" + paraStr;
			}
		}
		
		// 将参数转为Map
		if (reqPara != null || !reqPara.equals("")) {
			convertParaToMap();
		}
	}
	
	/** 将参数转为Map */
	private void convertParaToMap() {
		String[] split = reqPara.split("&");
		for (String str : split) {
			String[] kv = Arrays.copyOf(str.split("="), 2);
			String key = kv[0];
			String value = kv[1]==null?null:decode(kv[1], "UTF-8");
			if (!paraMap.containsKey(key)) {
				paraMap.put(key, new ArrayList<String>());
			}
			// 添加value
			paraMap.get(key).add(value);
		}
	}
	
	public String decode(String value, String enc) {
		String str = "";
		try {
			str = URLDecoder.decode(value,enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 根据key获取多个value
	 * @param key
	 * @return
	 */
	public String[] getParaValues(String key) {
		List<String> list = paraMap.get(key);
		if (list == null || list.size() < 0) {
			return null;
		}
		return list.toArray(new String[0]);
	}
	
	/**
	 * 根据key获取多个value
	 * @param key
	 * @return
	 */
	public String getParaValue(String key) {
		String[] values = getParaValues(key);
		return values == null ? null : values[0];
	}

	public String getReqMethod() {
		return reqMethod;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public String getReqPara() {
		return reqPara;
	}
	
	
}
