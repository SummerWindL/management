package com.hywl.cck.management.service;


import com.hywl.cck.management.entity.ProductInfo;

public interface ProductInfoService {
	
	  /**
	   *
	   * 通过品牌ID号获取商品详情
	   *
	   * @param brankId 品牌ID
	   * @return
	   */
	   public ProductInfo getProductByBrankId(Integer brankId);
	   
	   
		  /**
	   *
	   * 通过类别ID号获取商品详情
	   *
	   * @param categoryId 类别ID
	   * @return
	   */
	   public ProductInfo getProductByCategoryId(Integer categoryId);

}
