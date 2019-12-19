package com.liu.mapper;

import org.apache.ibatis.annotations.Select;

import com.liu.pojo.User;

public interface UserMapper {
	
	@Select("select * from user where username=#{0}")
	User selByUsername(String username);
}
