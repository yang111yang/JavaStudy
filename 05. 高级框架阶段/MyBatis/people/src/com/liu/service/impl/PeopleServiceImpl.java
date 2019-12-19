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
		//����mybatis�����ļ�
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//����sqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����sqlSession
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.liu.mapper.PeopleMapper.selAll");
		return list;
	}

}
