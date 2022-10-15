package com.czw.superProject.Dto;

import java.io.Serializable;

public class CarRepairInDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String carId;
	
	private String carNum;
	
	private String driver;
	
	private String phoneNum;
	
	private String carModel;
	
	private String repairTime;
	
	private String repairPlace;
	
	private Integer repairFunds;
	
	private String repairProject;
	
	private String repairOpinion;
	
	private String leaderApproval;
	
	private String remarks;

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	public String getRepairPlace() {
		return repairPlace;
	}

	public void setRepairPlace(String repairPlace) {
		this.repairPlace = repairPlace;
	}

	public Integer getRepairFunds() {
		return repairFunds;
	}

	public void setRepairFunds(Integer repairFunds) {
		this.repairFunds = repairFunds;
	}

	public String getRepairProject() {
		return repairProject;
	}

	public void setRepairProject(String repairProject) {
		this.repairProject = repairProject;
	}

	public String getRepairOpinion() {
		return repairOpinion;
	}

	public void setRepairOpinion(String repairOpinion) {
		this.repairOpinion = repairOpinion;
	}

	public String getLeaderApproval() {
		return leaderApproval;
	}

	public void setLeaderApproval(String leaderApproval) {
		this.leaderApproval = leaderApproval;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
