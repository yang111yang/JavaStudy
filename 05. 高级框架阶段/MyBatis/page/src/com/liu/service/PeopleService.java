package com.liu.service;

import java.io.IOException;

import com.liu.pojo.PageInfo;

public interface PeopleService {
	
	/**
	 * ∑÷“≥œ‘ æ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws IOException 
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;

}
