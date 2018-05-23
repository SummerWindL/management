package com.hywl.cck.management.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hywl.cck.base.unit.CategoryStortIdUtil;
import com.hywl.cck.management.entity.FirstCategoryInfo;
import com.hywl.cck.management.entity.SecondCategoryInfo;
import com.hywl.cck.management.mapper.FirstCategoryInfoMapper;
    import com.hywl.cck.management.service.FirstCategoryInfoService;

import redis.clients.jedis.Jedis;
	
	@Service("FirstCategoryInfoService")
	public class FirstCategoryInfoServiceImpl implements FirstCategoryInfoService{
		
		@Resource
	     private FirstCategoryInfoMapper oneCategoryInfoMapper;
		
		  /**
	   *
	   * 添加新品牌
	   *
	   * @param brankName 
	   * @return
	   */
	@Override
	public FirstCategoryInfo addCategoryInfo(String categoryName){
		
//		   CategoryStortIdUtil.putEcache("firstCategoryId","firstCategoryId",  String.valueOf(4));
		
		   Jedis jedis = new Jedis("111.230.248.224",6379);
           System.out.println("连接成功");
          //查看服务是否运行
           System.out.println("服务正在运行: "+jedis.ping());
		
		   FirstCategoryInfo oneCategoryInfo = new FirstCategoryInfo();
		   
		   String codeStr = CategoryStortIdUtil.getCode("firstCategoryId"); // 获取缓存中的验证码
		   int a = (Integer.valueOf(codeStr).intValue())+1;
		   oneCategoryInfo.setStortId(a);
		   oneCategoryInfo.setCategoryName(categoryName);
		   oneCategoryInfo.setCreateTime(new Date());
		   CategoryStortIdUtil.putEcache("firstCategoryId","firstCategoryId",  String.valueOf(a)); 
		   this.oneCategoryInfoMapper.addCategory(oneCategoryInfo);
		  
		  
		  return oneCategoryInfo;
		  
	  }
	
	
	/**
	   *
	   * 查询类别信息
	   *
	   * @param oneCategoryName 
	   * @return
	   */
	
	public FirstCategoryInfo getOneCategory(String oneCategoryName){
	  
	    return this.oneCategoryInfoMapper.getOneCategory(oneCategoryName);
	}
	
	/**
	*
	* 获取类别列表
	*
	* @return
	*/
	   public List<Map<String, Object>> getCategoryList(){
		   
		   return this.oneCategoryInfoMapper.getCategoryList();
	   }
	   
		  /**
	   *
	   * 通过ID号删除类别信息
	   *
	   * @param categoryId 一级类别ID号
	   * @return
	   */
     public void deletcategoryById(Integer categoryId){
    	 
    	 this.oneCategoryInfoMapper.deletcategoryById(categoryId);
    	 
     }
     
  	/**
  	*
  	* 通过stortId号获取上一条类别信息
  	* @param stortId 一级类别stortId号
  	* @return
  	*/
  	public FirstCategoryInfo getFirstcategoryById(Integer stortId){
  		
  		return this.oneCategoryInfoMapper.getFirstcategoryById(stortId);
  		
  	}
  	
	/**
	* 更新类别信息
	* @param id 一级类别id号
	* @return
	*/
	public void updateFirstCagegoryInfo(FirstCategoryInfo recd){
		
		
		this.oneCategoryInfoMapper.updateFirstCagegoryInfo(recd);
	}
	
	/**
	*
	* 通过stortId号获取下一条类别信息
	* @param stortId 一级类别stortId号
	* @return
	*/
	public FirstCategoryInfo getgoryById(Integer stortId){
		
		return this.oneCategoryInfoMapper.getgoryById(stortId);
		
	}
	
	
}
