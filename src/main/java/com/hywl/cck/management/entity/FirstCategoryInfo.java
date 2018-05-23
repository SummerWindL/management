package com.hywl.cck.management.entity;

import java.util.Date;

public class FirstCategoryInfo {
	private Integer id;
	private Integer stortId;
	private String categoryName;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStortId() {
		return stortId;
	}
	public void setStortId(Integer stortId) {
		this.stortId = stortId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
