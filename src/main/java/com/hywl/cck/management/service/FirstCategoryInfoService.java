package com.hywl.cck.management.service;


import java.util.List;
import java.util.Map;

import com.hywl.cck.management.entity.FirstCategoryInfo;

public interface FirstCategoryInfoService {
	
	  /**
	   *
	   * 添加新类别
	   *
	   * @param brankName 
	   * @return
	   */
	  public FirstCategoryInfo addCategoryInfo(String categoryName);
	  
	  
	  /**
	   *
	   * 查询类别信息
	   *
	   * @param oneCategoryName 
	   * @return
	   */
	  public FirstCategoryInfo getOneCategory(String oneCategoryName);
	  
	  
	   /**
	     *
	     * 获取类别列表
	     *
	     * @return
	     */
	   public List<Map<String, Object>> getCategoryList();
	    
	    
	    
	  /**
	   *
	   * 通过ID号类别信息
	   *
	   * @param categoryId 一级类别ID号
	   * @return
	   */
     public void deletcategoryById(Integer categoryId);
     
     
 	/**
 	*
 	* 通过stortId号获取上一条类别信息
 	* @param stortId 一级类别stortId号
 	* @return
 	*/
 	public FirstCategoryInfo getFirstcategoryById(Integer stortId);
 	
 	
	/**
	* 更新类别信息
	* @param id 一级类别id号
	* @return
	*/
	public void updateFirstCagegoryInfo(FirstCategoryInfo recd);
	
	
	/**
	*
	* 通过stortId号获取下一条类别信息
	* @param stortId 一级类别stortId号
	* @return
	*/
	public FirstCategoryInfo getgoryById(Integer stortId);
	
	

}
