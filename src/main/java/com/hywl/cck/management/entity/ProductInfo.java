package com.hywl.cck.management.entity;

import java.util.Date;

public class ProductInfo {
	
	private Integer id;
	private String proName; 
	private String proType;
	private String proMarque; //型号
	private String proPrice;  //商城价
	private String marketPrice; //市场价
	private String integralPrice; //积分价
	private Integer brandId; //品牌ID
	private Integer categoryId; //类别ID
	private Boolean proStatus;
	private String pSpecifi; //商品规格
	private String pVersion; //商品版本
	private String pWeight; //商品重量
	private Integer pStock; //商品库存数
	private Integer warningStock; //库存告警数
	private String pColor; //商品颜色
	private String pictureUrl; //商品图片地址
	private Boolean skuEnable; //商品是否是主sku
	private String pDescription; //商品描述
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getProMarque() {
		return proMarque;
	}
	public void setProMarque(String proMarque) {
		this.proMarque = proMarque;
	}
	public String getProPrice() {
		return proPrice;
	}
	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}
	public String getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getIntegralPrice() {
		return integralPrice;
	}
	public void setIntegralPrice(String integralPrice) {
		this.integralPrice = integralPrice;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Boolean getProStatus() {
		return proStatus;
	}
	public void setProStatus(Boolean proStatus) {
		this.proStatus = proStatus;
	}
	public String getpSpecifi() {
		return pSpecifi;
	}
	public void setpSpecifi(String pSpecifi) {
		this.pSpecifi = pSpecifi;
	}
	public String getpVersion() {
		return pVersion;
	}
	public void setpVersion(String pVersion) {
		this.pVersion = pVersion;
	}
	public String getpWeight() {
		return pWeight;
	}
	public void setpWeight(String pWeight) {
		this.pWeight = pWeight;
	}
	public Integer getpStock() {
		return pStock;
	}
	public void setpStock(Integer pStock) {
		this.pStock = pStock;
	}
	public Integer getWarningStock() {
		return warningStock;
	}
	public void setWarningStock(Integer warningStock) {
		this.warningStock = warningStock;
	}
	public String getpColor() {
		return pColor;
	}
	public void setpColor(String pColor) {
		this.pColor = pColor;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Boolean getSkuEnable() {
		return skuEnable;
	}
	public void setSkuEnable(Boolean skuEnable) {
		this.skuEnable = skuEnable;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
