package com.hywl.cck.management.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hywl.cck.management.entity.FirstCategoryInfo;

public interface FirstCategoryInfoMapper {
	
   /**
   *
   * 添加新类别
   *
   * @param record
   */
   public void addCategory(FirstCategoryInfo record);
   
	  /**
   *
   * 通过手机号码获取商户信息
   *
   * @param mobileNubmer 手机号码
   * @return
   */
   public FirstCategoryInfo getOneCategory(String oneCategoryName);
   
   
	 /**
	 *
	 * 获取类别列表
	 *
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getCategoryList();


  /**
   *
   * 通过ID号删除类别信息
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
 	public FirstCategoryInfo getFirstcategoryById(@Param(value="stortId")Integer stortId);
 	
 	
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
	public FirstCategoryInfo getgoryById(@Param(value="stortId")Integer stortId);
	

}
