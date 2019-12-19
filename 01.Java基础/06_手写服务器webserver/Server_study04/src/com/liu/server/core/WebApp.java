package com.liu.server.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.liu.user.Servlet;

public class WebApp {
	
	private static WebContext webContext = null;
	
	static {
		try {
			//1、获取解析工厂
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//2、从解析工厂获取解析器
			SAXParser parse =factory.newSAXParser();
			//3、编写处理器
			//4、加载文档 Document 注册处理器
			WebHandler handler=new WebHandler();
			parse.parse(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("web.xml")
					,handler );
			
			webContext = new WebContext(handler.getEntitys(), handler.getMappings());
			
		} catch (Exception e) {
			System.out.println("解析配置文件错误");
		}
	}
	
	public static Servlet getServletFromUrl(String url) {
		String className = webContext.getClz("/" + url);
		Servlet servlet = null;
		Class clz;
		try {
			if (className != null && !className.equals("")) {
				clz = Class.forName(className);
				servlet = (Servlet) clz.getConstructor().newInstance();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servlet;
	}

}
