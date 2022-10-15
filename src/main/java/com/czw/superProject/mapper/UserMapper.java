package com.czw.superProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.czw.superProject.Dto.UserDto;
import com.czw.superProject.bean.User;


@Mapper
public interface UserMapper {

	public User getByUserNameAndPassword(User user);
	
	public int insertUser(User user);
	
	public UserDto getMaxUserId();
}
