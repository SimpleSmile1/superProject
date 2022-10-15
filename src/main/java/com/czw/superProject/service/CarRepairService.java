package com.czw.superProject.service;

import java.util.List;

import com.czw.superProject.Dto.CarRepairInDto;
import com.czw.superProject.Dto.CarRepairOutDto;

public interface CarRepairService {

	public int insertCarRepairInfo(CarRepairInDto inDto);
	
	public int updateCarRepairInfo(CarRepairInDto inDto);
	
	public List<CarRepairOutDto> getCarRepairInfoByCarNum(String carNum);
	
	public CarRepairOutDto getCarRepairInfoById(String carId);
	
	public String repairInfoDown(String format);
}
