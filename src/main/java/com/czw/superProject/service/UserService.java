package com.czw.superProject.service;

import com.czw.superProject.Dto.UserRegisterInDto;
import com.czw.superProject.bean.User;

public interface UserService {

	public User getByUserNameAndPassword(String username, String password);
	
	public int registerUser(UserRegisterInDto inDto);
}
