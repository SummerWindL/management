package com.hywl.cck.direct.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.direct.entity.DirGiftInfo;

public interface DirectGiftInfoService {
	
	/**
    *
    * 查询礼物信息
    * @param map
    * @return
    */
   public PageInfo<Map<String, Object>> selectGiftInfoList(Map<String, Object> map);
   
   /**
   *
   * 添加礼物信息
   *
   * @param record
   * @return
   */
   public int add(DirGiftInfo dirGiftInfo);
   
   /***
    * 删除礼物信息
    * @return 
    */
   public void delete(String giftInfoId);
   
   /**
   *
   * 获取礼物信息
   *
   * @param 
   * @return
   */
    public DirGiftInfo get(String cuisineInfoId);
    
    /**
	 *
	 * 更新菜系信息
	 *
	 * @param record
	 * @return
	 */
    public int update(DirGiftInfo record);
   
}
