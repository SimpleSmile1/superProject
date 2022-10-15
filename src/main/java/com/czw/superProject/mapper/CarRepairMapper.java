package com.czw.superProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.czw.superProject.Dao.CarRepairDao;
import com.czw.superProject.bean.CarRepair;

@Mapper
public interface CarRepairMapper {
	
	public int insertCarRepairInfo(CarRepair carRepair);
	
	public int updateCarRepairInfo(CarRepair carRepair);
	
	public List<CarRepairDao> getCarRepairInfo(String carNum);
	
	public CarRepairDao getCarRepairInfoById(String carId);
}
