package com.hywl.cck.management.mapper;

import java.util.List;
import java.util.Map;

import com.hywl.cck.management.entity.BrankInfo;

public interface BrankInfoMapper{
	
	  /**
	   *
	   * 通过手机号码获取商户信息
	   *
	   * @param mobileNubmer 手机号码
	   * @return
	   */
	   public BrankInfo getBrank(String brankName);
	   
	   /**
	   *
	   * 添加新品牌
	   *
	   * @param record
	   */
	   public void registerBrank(BrankInfo record);
	   
	   /**
	   *
	   * 删除某个品牌
	   *
	   * @param record
	   */
	   public void deleteBrank(String brankName);
	   
	   
	    /**
	    *
	    * 获取品牌列表
	    *
	    * @return
	    */
	   public List<Map<String, Object>> getBrankList();

}
