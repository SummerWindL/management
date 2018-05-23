package com.hywl.cck.direct.mapper;

import java.util.List;
import java.util.Map;

import com.hywl.cck.direct.entity.DirGiftInfo;

public interface DirGiftInfoMapper {
    int deleteByPrimaryKey(String giftInfoId);

    int insert(DirGiftInfo record);

    int insertSelective(DirGiftInfo record);

    DirGiftInfo selectByPrimaryKey(String giftInfoId);

    int updateByPrimaryKeySelective(DirGiftInfo record);

    int updateByPrimaryKey(DirGiftInfo record);
    
    /**
    *
    * 查询礼物信息
    *
    * @param map
    * @return
    */
   public List<Map<String, Object>> selectGiftInfoList(Map<String, Object> map);
}