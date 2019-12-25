package com.liu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.liu.pojo.User;

public interface UserMapper {
	@Select("select * from user where username=#{username} and password=#{password}")
	List<User> selAll(User user);
}
