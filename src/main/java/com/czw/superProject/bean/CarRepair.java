package com.czw.superProject.bean;

import java.io.Serializable;
import java.util.Date;

public class CarRepair implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String carNum;
	
	private String driver;
	
	private String phoneNum;
	
	private String carModel;
	
	private Date repairTime;
	
	private String repairPlace;
	
	private Integer repairFunds;
	
	private String repairProject;
	
	private String repairOpinion;
	
	private String leaderApproval;
	
	private String remarks;
	
	private Date createTime;
	
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(Date repairTime) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
