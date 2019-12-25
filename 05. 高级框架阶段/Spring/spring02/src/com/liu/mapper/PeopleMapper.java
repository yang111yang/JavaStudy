package com.liu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.liu.pojo.People;

public interface PeopleMapper {
	@Select("select * from people")
	List<People> selAll();
	
}
