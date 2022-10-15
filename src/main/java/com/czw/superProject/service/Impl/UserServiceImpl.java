package com.czw.superProject.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czw.superProject.CommonUtils.MD5Util;
import com.czw.superProject.CommonUtils.NumUtils;
import com.czw.superProject.Dto.UserDto;
import com.czw.superProject.Dto.UserRegisterInDto;
import com.czw.superProject.bean.User;
import com.czw.superProject.mapper.UserMapper;
import com.czw.superProject.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getByUserNameAndPassword(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5Util.md5Encode(password));
		User loginUser = userMapper.getByUserNameAndPassword(user);
		return loginUser;
	}

	@Override
	public int registerUser(UserRegisterInDto inDto) {
		UserDto userDto = userMapper.getMaxUserId();
		long id = 0;
		if (userDto != null) {
			String userId = userDto.getId();
			id = (long)(Long.valueOf(userId) + 1);
		}
		User user = new User();
		user.setId(id);
		user.setUsername(inDto.getUsername());
		user.setPassword(MD5Util.md5Encode(inDto.getPassword()));
		user.setEmail(inDto.getEmail());
		user.setAvatar("https://unsplash.it");
		user.setNickname(inDto.getNickname());
		user.setType(NumUtils.randomNum());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		int result = userMapper.insertUser(user);
		return result;
	}

}
