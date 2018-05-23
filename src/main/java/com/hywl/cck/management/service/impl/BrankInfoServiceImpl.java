package com.hywl.cck.management.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hywl.cck.management.entity.BrankInfo;
import com.hywl.cck.management.mapper.BrankInfoMapper;
import com.hywl.cck.management.mapper.MerchantInfoMapper;
import com.hywl.cck.management.service.BrankInfoService;


@Service("BrankInfoService")
public class BrankInfoServiceImpl implements BrankInfoService{
	
    @Resource
    private BrankInfoMapper brankInfoMapper;   
	
		/**
	   *
	   * 通过品牌名获取品牌信息
	   * @param brankName 品牌名称
	   * @return
	   */
	   
	   @Override
	   public BrankInfo getBrank(String brankName){
		   return this.brankInfoMapper.getBrank(brankName);
	   }
	   
	   
		/**
	   *
	   * 添加新品牌
	   * @param brankName 品牌名称
	   * @return
	   */
	   public BrankInfo addBrankInfo(String brankName){
		   
		   BrankInfo brankInfo = new BrankInfo();
		   brankInfo.setBrankName(brankName);
		   brankInfo.setCreateTime(new Date());
		   brankInfo.setModifTime(new Date());
		   brankInfo.setDeletTime(new Date());
		   this.brankInfoMapper.registerBrank(brankInfo);
		   System.out.println("new Date()----"+new Date());
		   return brankInfo;
	   }
	   
		  /**
	   *
	   * 删除某个品牌
	   *
	   * @param brankName 
	   * @return
	   */
	   public void deleteBrank (String brankName){
		   this.brankInfoMapper.deleteBrank(brankName);
	   }

	   
	    /**
	    *
	    * 获取品牌列表
	    *
	    * @return
	    */
	   public List<Map<String, Object>> getBrankList(){
		   
		   
		   return this.brankInfoMapper.getBrankList();
	   }
}
