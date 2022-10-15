package com.czw.superProject.controller;

import java.util.HashMap;
import java.util.List;
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

import com.czw.superProject.Dto.CarRepairInDto;
import com.czw.superProject.Dto.CarRepairOutDto;
import com.czw.superProject.service.CarRepairService;

@Controller
public class CarRepairController {
	
	@Autowired
	private CarRepairService carRepairService;
	
	@RequestMapping(value="/carRepairLogin",consumes = "application/*", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Map<String,String> carRepairInfoLogin(@RequestBody CarRepairInDto inDto) {
		Logger logger = LoggerFactory.getLogger(getClass());
		Map<String, String> mapStr = new HashMap<>();
		int result = carRepairService.insertCarRepairInfo(inDto);
		
		if (result > 0) {
			logger.info("success");
			mapStr.put("key", "success");
			mapStr.put("carNum", inDto.getCarNum());
		}
		return mapStr;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@ResponseBody
	@RequestMapping(value="/getCarRepairInfo", consumes = "application/*", method = RequestMethod.POST)
	public List<CarRepairOutDto> getCarRepairInfo(@RequestParam String carNum) {
		return carRepairService.getCarRepairInfoByCarNum(carNum);
	}
}
