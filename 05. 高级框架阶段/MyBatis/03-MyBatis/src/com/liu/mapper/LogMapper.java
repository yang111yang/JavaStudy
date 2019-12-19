package com.liu.mapper;

import java.util.List;

import com.liu.pojo.Log;

public interface LogMapper {
	List<Log> selAll();
	List<Log> selByAccInAccOut(String accIn, String accOut);
}
