package com.hywl.cck.management.entity;

import java.util.Date;

public class MerchantInfo {
	
	private Integer id;
	private String merchantId;
	private String linkMan;
	private String merName;
	private String merAddress;
	private String merPhone;
	private String merPassword;
	private String merIdcard;
	private Date createTime;
	private String merType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getMerAddress() {
		return merAddress;
	}
	public void setMerAddress(String merAddress) {
		this.merAddress = merAddress == null ? "深圳市" : merAddress;
	}
	public String getMerPhone() {
		return merPhone;
	}
	public void setMerPhone(String merPhone) {
		this.merPhone = merPhone;
	}
	public String getMerPassword() {
		return merPassword;
	}
	public void setMerPassword(String merPassword) {
		this.merPassword = merPassword;
	}
	public String getMerIdcard() {
		return merIdcard;
	}
	public void setMerIdcard(String merIdcard) {
		this.merIdcard = merIdcard;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getMerType() {
		return merType;
	}
	public void setMerType(String merType) {
		this.merType = merType;
	}
	
	

}
