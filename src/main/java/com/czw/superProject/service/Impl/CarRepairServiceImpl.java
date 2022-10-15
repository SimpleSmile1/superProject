package com.czw.superProject.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czw.superProject.CommonUtils.DateUtils;
import com.czw.superProject.Dao.CarRepairDao;
import com.czw.superProject.Dto.CarRepairInDto;
import com.czw.superProject.Dto.CarRepairOutDto;
import com.czw.superProject.bean.CarRepair;
import com.czw.superProject.mapper.CarRepairMapper;
import com.czw.superProject.service.CarRepairService;

@Service("carRepairService")
public class CarRepairServiceImpl implements CarRepairService{

	@Autowired
	private CarRepairMapper carRepairMapper;
	@Override
	public int insertCarRepairInfo(CarRepairInDto inDto) {
		CarRepair carRepair = new CarRepair();
		carRepair.setCarNum(inDto.getCarNum());
		carRepair.setCarModel(inDto.getCarModel());
		carRepair.setDriver(inDto.getDriver());
		carRepair.setLeaderApproval(inDto.getLeaderApproval());
		carRepair.setPhoneNum(inDto.getPhoneNum());
		carRepair.setRemarks(inDto.getRemarks());
		carRepair.setRepairFunds(inDto.getRepairFunds());
		carRepair.setRepairOpinion(inDto.getRepairOpinion());
		carRepair.setRepairPlace(inDto.getRepairPlace());
		carRepair.setRepairProject(inDto.getRepairProject());
		carRepair.setRepairTime(DateUtils.string2Date(inDto.getRepairTime()));
		carRepair.setUpdateTime(new Date());
		carRepair.setCreateTime(new Date());
		return carRepairMapper.insertCarRepairInfo(carRepair);
	}

	@Override
	public List<CarRepairOutDto> getCarRepairInfoByCarNum(String carNum) {
		List<CarRepairOutDto> outDtoList = new ArrayList<CarRepairOutDto>();
		List<CarRepairDao> carRepairDaoList = carRepairMapper.getCarRepairInfo(carNum);
		carRepairDaoList.forEach(carRepairDao->{
			CarRepairOutDto outDto = new CarRepairOutDto();
			outDto.setId(carRepairDao.getId());
			outDto.setCarModel(carRepairDao.getCarModel());
			outDto.setCarNum(carRepairDao.getCarNum());
			outDto.setDriver(carRepairDao.getDriver());
			outDto.setLeaderApproval(carRepairDao.getLeaderApproval());
			outDto.setPhoneNum(carRepairDao.getPhoneNum());
			outDto.setRemarks(carRepairDao.getRemarks());
			outDto.setRepairFunds(carRepairDao.getRepairFunds());
			outDto.setRepairOpinion(carRepairDao.getRepairOpinion());
			outDto.setRepairPlace(carRepairDao.getRepairPlace());
			outDto.setRepairProject(carRepairDao.getRepairProject());
			outDto.setRepairTime(DateUtils.date2String(carRepairDao.getRepairTime()));
			outDtoList.add(outDto);
		});
		return outDtoList;
	}

}
