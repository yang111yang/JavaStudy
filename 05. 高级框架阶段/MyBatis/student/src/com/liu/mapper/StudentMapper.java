package com.liu.mapper;

import java.util.List;

import com.liu.pojo.PageInfo;
import com.liu.pojo.Student;

public interface StudentMapper {
	
	List<Student> selByPage(PageInfo pageInfo);
	long selCount(PageInfo pageInfo);
	
}
