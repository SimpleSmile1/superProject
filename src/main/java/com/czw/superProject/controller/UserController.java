package com.czw.superProject.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czw.superProject.Dto.UserRegisterInDto;
import com.czw.superProject.bean.User;
import com.czw.superProject.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@CrossOrigin(origins = "*",maxAge = 3600)
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/*")
	public Map<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Logger logger = LoggerFactory.getLogger(getClass());
		Map<String, Object> resultMap = new HashMap<>();
		logger.info("myLog");
		User loginUser = userService.getByUserNameAndPassword(username, password);
		if (loginUser != null) {
			resultMap.put("key", "success");
		}
		return resultMap;
	}
	
	@ResponseBody
	@CrossOrigin(origins = "*",maxAge = 3600)
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/*")
	public Map<String, Object> register(@RequestBody UserRegisterInDto inDto) {
		Logger logger = LoggerFactory.getLogger(getClass());
		Map<String, Object> resultMap = new HashMap<>();
		logger.info("myLog");
		int result = userService.registerUser(inDto);
		if (result > 0) {
			resultMap.put("key", "success");
		}
		return resultMap;
	}

}
