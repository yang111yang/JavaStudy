package com.liu.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.pojo.PageInfo;
import com.liu.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map = new HashMap<>();
		map.put("pageStart", pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("com.liu.mapper.PeopleMapper.selByPage",map));
		long count = session.selectOne("com.liu.mapper.PeopleMapper.selCount");
		System.out.println(session.selectList("com.liu.mapper.PeopleMapper.selByPage",map));
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
