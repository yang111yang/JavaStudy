package com.liu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.liu.mapper.PeopleMapper;
import com.liu.pojo.People;
import com.liu.service.PeopleService;
import com.liu.util.MyBatisUtil;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> selAll() {
		SqlSession session = MyBatisUtil.getSession();
		PeopleMapper mapper = session.getMapper(PeopleMapper.class);
		List<People> list = mapper.selAll();
		return list;
	}

}
