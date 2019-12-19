package com.liu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.mapper.LogMapper;
import com.liu.pojo.Log;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		LogMapper logMapper = session.getMapper(LogMapper.class);
//		List<Log> list = logMapper.selAll();
		List<Log> list = logMapper.selByAccInAccOut("1", "3");
		for (Log log : list) {
			System.out.println(log);
		}
	}
}
