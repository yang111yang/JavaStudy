package com.liu.service;

import java.io.IOException;

import com.liu.pojo.PageInfo;

public interface LogService {
	
	/**
	 * ��־��ҳ��ѯ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws IOException 
	 */
	PageInfo showLog(int pageSize,int pageNumber) throws IOException;
}
