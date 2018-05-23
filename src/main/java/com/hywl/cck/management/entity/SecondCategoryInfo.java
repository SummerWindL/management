package com.hywl.cck.management.entity;

import java.util.Date;

public class SecondCategoryInfo {
	  
	  private Integer id;
	  private Integer stortId; 
	  private Integer firstCategoryId; //一级类别ID
	  private String secCategoryName; //二级级类别名称
	  private String categoryImg; //类别图片
	  private Date creatTime;
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
	public Integer getFirstCategoryId() {
		return firstCategoryId;
	}
	public void setFirstCategoryId(Integer firstCategoryId) {
		this.firstCategoryId = firstCategoryId;
	}

	public String getSecCategoryName() {
		return secCategoryName;
	}
	public void setSecCategoryName(String secCategoryName) {
		this.secCategoryName = secCategoryName;
	}
	public String getCategoryImg() {
		return categoryImg;
	}
	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	  
	  

}
