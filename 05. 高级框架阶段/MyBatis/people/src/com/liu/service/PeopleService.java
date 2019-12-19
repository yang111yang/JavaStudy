package com.liu.service;

import java.io.IOException;
import java.util.List;

import com.liu.pojo.People;

public interface PeopleService {
	
	
	/**
	 * 查询所有人员信息
	 * @return
	 * @throws IOException 
	 */
	List<People> show() throws IOException;
}
