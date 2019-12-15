package com.liu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liu.pojo.People;

public interface PeopleMapper {
	
	List<People> selAll();
}
