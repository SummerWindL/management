package com.hywl.cck.management.service.impl;

import java.util.Date;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hywl.cck.base.unit.db.IdWorkerAide;
import com.hywl.cck.base.unit.db.TablePrefixUtil;
import com.hywl.cck.management.entity.BrankInfo;
import com.hywl.cck.management.entity.MerchantInfo;
import com.hywl.cck.management.mapper.MerchantInfoMapper;
import com.hywl.cck.management.service.MerchantInfoService;

@Service("MerchantInfoService")
public class MerchantServiceImpl implements MerchantInfoService{
	
    @Resource
    private MerchantInfoMapper merchantInfoMapper;
	
	 /**
    *
    * 通过手机号码获取用户信息
    * @param mobileNubmer 手机号码
    * @return
    */
   @Override
   public MerchantInfo getMerchantByPhoneNumber(String mobileNubmer) {
	   
	   
       return this.merchantInfoMapper.getMerchantByPhoneNumber(mobileNubmer);
	   
   }
   
   
   
   @Override
   public MerchantInfo register(String mobileNumber, String merchantName, String linksman, String idCard, String merchantType){
	   
	   String merchantInfoId = TablePrefixUtil.user_info + String.valueOf(IdWorkerAide.nextId());
	    MerchantInfo merchantInfo = new MerchantInfo();

//	    merchantInfo.setMerPhone(mobileNumber);
//	
//	    merchantInfo.setMerchantId(merchantInfoId);
//	    merchantInfo.setLinkMan(linksman);
//	    merchantInfo.setMerName(merchantName);
//	    merchantInfo.setMerPassword("12345678");
//	    merchantInfo.setMerIdcard(idCard);
//	    merchantInfo.setCreateTime(new Date());
//	    merchantInfo.setMerType(merchantType);
	    
	    merchantInfo.setMerPhone("123456");
		
	    merchantInfo.setMerchantId(merchantInfoId);
	    merchantInfo.setLinkMan("张三");
	    merchantInfo.setMerName("厨神多金");
	    merchantInfo.setMerPassword("12345678");
	    merchantInfo.setMerIdcard("123456");
	    merchantInfo.setCreateTime(new Date());
	    merchantInfo.setMerType("1");
	 
	    this.merchantInfoMapper.registerMerchant(merchantInfo);
	   
	    return merchantInfo;
   }
   


   


}
