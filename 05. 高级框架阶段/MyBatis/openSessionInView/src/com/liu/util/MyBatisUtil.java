package com.liu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
	private static SqlSessionFactory factory;
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if (session == null) {
			session = factory.openSession();
			threadLocal.set(session);
		}
		return threadLocal.get();
	}
	
	public static void closeSession() {
		SqlSession session = MyBatisUtil.getSession();
		session.close();
	}
}
