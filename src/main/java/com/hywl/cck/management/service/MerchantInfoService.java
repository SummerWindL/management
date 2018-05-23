package com.hywl.cck.management.service;

import com.hywl.cck.management.entity.BrankInfo;
import com.hywl.cck.management.entity.MerchantInfo;

public interface MerchantInfoService {
	
    /**
    *
    * 通过手机号码获取商户信息
    *
    * @param mobileNubmer 手机号码
    * @return
    */
   public MerchantInfo getMerchantByPhoneNumber(String mobileNubmer);
   
   
   /**
   *
   * 通过手机号码获取商户信息
   *
   * @param mobileNubmer 手机号码
   * @return
   */
   public MerchantInfo register(String mobileNumber, String merchantName, String linksman, String idCard, String merchantType);
  
   
 
   
}