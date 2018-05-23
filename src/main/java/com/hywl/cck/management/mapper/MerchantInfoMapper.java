package com.hywl.cck.management.mapper;

import com.hywl.cck.management.entity.MerchantInfo;


public interface MerchantInfoMapper {
	
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
   * 用户注册
   *
   * @param record
   */
   public void registerMerchant(MerchantInfo record);
  
  
  
 

}
