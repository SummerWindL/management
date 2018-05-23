package com.hywl.cck.management.service;

import java.util.List;
import java.util.Map;

import com.hywl.cck.management.entity.FirstCategoryInfo;
import com.hywl.cck.management.entity.SecondCategoryInfo;

public interface SecondCategoryInfoService {

  /**
   *
   * 查询类别信息
   *
   * @param 一级分类id 
   * @return
   */
  public SecondCategoryInfo getCategoryInfo(Integer categoryId);
  
  
  /**
   *
   * 查询二级类别名称是否存在
   *
   * @param 一级分类id 
   * @return
   */
  public SecondCategoryInfo getSecCategoryByName(String secCategoryName);
  
  
  
   /**
   *
   * 添加二级新类别
   *
   * @param firstcategoryId
   * @param secCategoryName
   */
   public SecondCategoryInfo addSecCategory(Integer firstcategoryId,String secCategoryName);
   
   /**
   *
   * 获取二级类别列表
   *
   * @return
   */
   public List<Map<String, Object>> getSecCategoryList();
   
	  /**
   *
   * 通过ID号类别信息
   *
   * @param categoryId 二级类别ID号
   * @return
   */
    public void deletSeccategoryById(Integer categoryId);
    
    
	/**
	*
	* 通过stortId号获取上一条类别信息
	* @param stortId 二级类别stortId号
	* @return
	*/
	public SecondCategoryInfo getSeccategoryById(Integer stortId);
	
	
	
	
	/**
	* 更新类别信息
	* @param id 二级类别id号
	* @return
	*/
	public void updateCagegoryInfo(SecondCategoryInfo recd);
	
	
	/**
	*
	* 通过stortId号获取下一条类别信息
	* @param stortId 二级类别stortId号
	* @return
	*/
	public SecondCategoryInfo getgoryById(Integer stortId);
	

}
