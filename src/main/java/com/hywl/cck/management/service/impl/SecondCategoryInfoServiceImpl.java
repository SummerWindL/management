package com.hywl.cck.management.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hywl.cck.base.unit.CategoryStortIdUtil;
import com.hywl.cck.management.entity.SecondCategoryInfo;
import com.hywl.cck.management.mapper.SecondCategoryInfoMapper;
import com.hywl.cck.management.service.SecondCategoryInfoService;

@Service("SecondCategoryInfoService")
public class SecondCategoryInfoServiceImpl implements SecondCategoryInfoService{
	
	@Resource
	private SecondCategoryInfoMapper secondInfoMapper;
	
	  /**
	   *
	   * 查询类别信息
	   *
	   * @param 一级分类id 
	   * @return
	   */
	@Override
	public SecondCategoryInfo getCategoryInfo(Integer categoryId){
		  
		  
		  return this.secondInfoMapper.getCategoryInfo(categoryId);
	}
	
	
	  /**
	   *
	   * 查询二级类别名称是否存在
	   *
	   * @param 一级分类id 
	   * @return
	   */
	@Override
	public SecondCategoryInfo getSecCategoryByName(String secCategoryName){
		
		
		return this.secondInfoMapper.getSecCategoryByName(secCategoryName);
	}
	
   /**
   * 添加二级新类别
   * @param record
   */
	@Override
    public SecondCategoryInfo addSecCategory(Integer firstcategoryId,String secCategoryName){
	   
		 CategoryStortIdUtil.putEcache("secondCategoryId","secondCategoryId",  String.valueOf(2));
		 SecondCategoryInfo secCategoryInfo = new SecondCategoryInfo();
		 String codeStr = CategoryStortIdUtil.getCode("secondCategoryId"); // 获取缓存中的验证码
		 int a = (Integer.valueOf(codeStr).intValue())+1;
		 secCategoryInfo.setStortId(a);
		 CategoryStortIdUtil.putEcache("secondCategoryId","secondCategoryId",  String.valueOf(a)); 
		 secCategoryInfo.setFirstCategoryId(firstcategoryId);
	     secCategoryInfo.setSecCategoryName(secCategoryName);
	     secCategoryInfo.setCategoryImg("http://123456");
		 secCategoryInfo.setCreatTime(new Date());
		 this.secondInfoMapper.addSecCategory(secCategoryInfo);
		 
		 return secCategoryInfo;
   
    }
	
	
	   /**
	   *
	   * 获取二级类别列表
	   *
	   * @return
	   */
	   public List<Map<String, Object>> getSecCategoryList(){
		   
		   
		   return this.secondInfoMapper.getSecCategoryList();
	   }
	   
	   
	   /**
	   *
	   * 通过ID号删除类别信息
	   *
	   * @param categoryId 二级类别ID号
	   * @return
	   */
	  public void deletSeccategoryById(Integer categoryId){
		  this.secondInfoMapper.deletSeccategoryById(categoryId);
	  }
	  
		/**
		*
		* 通过stortId号获取上一条类别信息
		* @param stortId 二级类别stortId号
		* @return
		*/
		public SecondCategoryInfo getSeccategoryById(Integer stortId){
			
			return this.secondInfoMapper.getSeccategoryById(stortId);
		}

		/**
		*
		* 更新类别stortid信息
		* @param id 二级类别id号
		* @return
		*/
		public void updateCagegoryInfo(SecondCategoryInfo recd){

			this.secondInfoMapper.updateCagegoryInfo(recd);
			
		}
		
		/**
		*
		* 通过stortId号获取下一条类别信息
		* @param stortId 二级类别stortId号
		* @return
		*/
		public SecondCategoryInfo getgoryById(Integer stortId){
			
			return this.secondInfoMapper.getgoryById(stortId);
			
		}
	   
}
