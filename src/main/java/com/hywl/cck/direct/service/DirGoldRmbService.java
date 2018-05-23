package com.hywl.cck.direct.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.direct.entity.DirGiftInfo;
import com.hywl.cck.direct.entity.DirGoldRmb;

public interface DirGoldRmbService {
	
	/**
    *
    * 查询分页
    * @param map
    * @return
    */
   public PageInfo<Map<String, Object>> selectGoldRmbList(Map<String, Object> map);
   
   /***
    * 增加
    * @param dirGoldRmb
    * @return
    */
   public int add(DirGoldRmb dirGoldRmb);
   
   /***
    * 删除
    * @param giftGoldId
    */
   public void delete(String giftGoldId);
   
   /***
    * 修改
    * @param dirGoldRmb
    * @return
    */
   public int update(DirGoldRmb dirGoldRmb);
   
   /**
   *
   * 获取信息
   *
   * @param 
   * @return
   */
    public DirGoldRmb get(String giftGoldId);
}
