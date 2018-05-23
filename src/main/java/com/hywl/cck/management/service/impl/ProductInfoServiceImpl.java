package com.hywl.cck.management.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hywl.cck.management.entity.ProductInfo;
import com.hywl.cck.management.mapper.ProductInfoMapper;
import com.hywl.cck.management.service.ProductInfoService;

@Service("ProductInfoService")
public class ProductInfoServiceImpl implements ProductInfoService{
	
	  @Resource
	  private ProductInfoMapper productInfoMapper;
	
	  /**
	   *
	   * 通过品牌ID号获取商品详情
	   *
	   * @param brankId 品牌ID
	   * @return
	   */
	   @Override
	   public ProductInfo getProductByBrankId(Integer brankId){
		   
		   return this.productInfoMapper.getProductByBrankId(brankId);
	   }

		  /**
	   *
	   * 通过类别ID号获取商品详情
	   *
	   * @param categoryId 类别ID
	   * @return
	   */
	   @Override
	   public ProductInfo getProductByCategoryId(Integer categoryId){
		   return this.productInfoMapper.getProductByBrankId(categoryId);
		   
	   }
}
