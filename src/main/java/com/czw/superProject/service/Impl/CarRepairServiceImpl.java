package com.czw.superProject.service.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.czw.superProject.CommonUtils.DateUtils;
import com.czw.superProject.CommonUtils.FileUtils;
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

	@Override
	public CarRepairOutDto getCarRepairInfoById(String carId) {
		CarRepairDao carRepairDao = carRepairMapper.getCarRepairInfoById(carId);
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
		return outDto;
	}

	@Override
	public int updateCarRepairInfo(CarRepairInDto inDto) {
		CarRepair carRepair = new CarRepair();
		carRepair.setId(Integer.parseInt(inDto.getCarId()));
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
		int result = carRepairMapper.updateCarRepairInfo(carRepair);
		return result;
	}

	@Override
	public String repairInfoDown(String format) {
		String result = "0";
		if (StringUtils.equals(format, "csv")) {
			List<Object> head = new ArrayList<>();
			head.add("驾驶员姓名");
			head.add("手机号");
			head.add("车牌号");
			head.add("车型");
			head.add("维修时间");
			head.add("维修地点");
			head.add("维修经费");
			head.add("维修项目");
			head.add("维修意见");
			head.add("领导审批");
			head.add("备注");
			List<List<Object>> dataList = new ArrayList<>();
			List<CarRepairDao> carRepairDaoList = carRepairMapper.getCarRepairInfo("");
			carRepairDaoList.forEach(carRepairDao->{
				List<Object> list = new ArrayList<>();
				list.add(carRepairDao.getDriver());
				list.add(carRepairDao.getPhoneNum());
				list.add(carRepairDao.getCarNum());
				list.add(carRepairDao.getCarModel());
				list.add(DateUtils.date2String(carRepairDao.getRepairTime()));
				list.add(carRepairDao.getRepairPlace());
				list.add(Integer.toString(carRepairDao.getRepairFunds()));
				list.add(carRepairDao.getRepairProject());
				list.add(carRepairDao.getRepairOpinion());
				list.add(carRepairDao.getLeaderApproval());
				list.add(carRepairDao.getRemarks());
				dataList.add(list);
			});
			String outPutPath = "d:/export/";
			String fileName = "汽车维修单";
			File csvFile= FileUtils.createCSVFile(head, dataList, outPutPath, fileName);
			if (csvFile != null) {
				result = "1";
			}
		} else {
			
		}
		return result;
	}
}
