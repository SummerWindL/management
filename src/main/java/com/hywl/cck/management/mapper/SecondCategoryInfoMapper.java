package com.hywl.cck.management.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hywl.cck.management.entity.SecondCategoryInfo;

public interface SecondCategoryInfoMapper {

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
    * @param record
    */
    public void addSecCategory(SecondCategoryInfo record);
    
    
	
	 /**
	 *
	 * 获取二级类别列表
	 *
	 * @return
	 */
	public List<Map<String, Object>> getSecCategoryList();
	
	
	 /**
	   *
	   * 通过ID号删除类别信息
	   *
	   * @param categoryId 二级类别ID号
	   * @return
	   */
	public void deletSeccategoryById(Integer categoryId);
	
	/**
	* 通过stortId号获取上一条类别信息
	* @param stortId 二级类别stortId号
	* @return                                  
	*/                                        
	public SecondCategoryInfo getSeccategoryById(@Param(value="stortId")Integer stortId);
	
	/**
	*
	* 更新类别信息
	* @return
	*/
	public void updateCagegoryInfo(SecondCategoryInfo recd);
	
	/**
	*
	* 通过stortId号获取下一条类别信息
	* @param stortId 二级类别stortId号
	* @return
	*/
	public SecondCategoryInfo getgoryById(@Param(value="stortId")Integer stortId);
	
	
	
	
}
