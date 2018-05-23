package com.hywl.cck.management.service;

import java.util.List;
import java.util.Map;

import com.hywl.cck.management.entity.BrankInfo;

public interface BrankInfoService {
	
	  /**
	   *
	   * 通过品牌名获取品牌信息
	   *
	   * @param brankName 
	   * @return
	   */
	  public BrankInfo getBrank(String brankName);
	  
	  
	  /**
	   *
	   * 添加新品牌
	   *
	   * @param brankName 
	   * @return
	   */
	  public BrankInfo addBrankInfo(String brankName); 
	  
	  
	  /**
	   *
	   * 删除某个品牌
	   *
	   * @param brankName 
	   * @return
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
