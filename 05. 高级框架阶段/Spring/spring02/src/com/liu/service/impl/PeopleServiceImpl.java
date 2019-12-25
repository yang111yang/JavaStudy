package com.liu.service.impl;

import java.util.List;

import com.liu.mapper.PeopleMapper;
import com.liu.pojo.People;
import com.liu.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {
	
	private PeopleMapper peopleMapper;
	
	public PeopleMapper getPeopleMapper() {
		return peopleMapper;
	}

	public void setPeopleMapper(PeopleMapper peopleMapper) {
		this.peopleMapper = peopleMapper;
	}

	@Override
	public List<People> showPeople() {
		return peopleMapper.selAll();
	}

}
