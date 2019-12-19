package com.liu.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.pojo.People;
import com.liu.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> show() throws IOException {
		//加载mybatis配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//创建sqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//创建sqlSession
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.liu.mapper.PeopleMapper.selAll");
		return list;
	}

}
