package com.liu.service;

import java.io.IOException;
import java.util.List;

import com.liu.pojo.People;

public interface PeopleService {
	
	
	/**
	 * ��ѯ������Ա��Ϣ
	 * @return
	 * @throws IOException 
	 */
	List<People> show() throws IOException;
}
