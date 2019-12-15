package com.liu.service;

import com.liu.pojo.PageInfo;

public interface StudentService {
	
	PageInfo selByPage(String pageSizeStr, String pageNumberStr, String sname, String tname);
	
}
