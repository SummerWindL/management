package com.hywl.cck.management.entity;

import java.util.Date;

public class BrankInfo {
	
	private Integer id;
	private String brankName;
	private Date createTime;
	private Date modifTime;
	private Date deletTime;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrankName() {
		return brankName;
	}
	public void setBrankName(String brankName) {
		this.brankName = brankName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifTime() {
		return modifTime;
	}
	public void setModifTime(Date modifTime) {
		this.modifTime = modifTime;
	}
	public Date getDeletTime() {
		return deletTime;
	}
	public void setDeletTime(Date deletTime) {
		this.deletTime = deletTime;
	}


}
