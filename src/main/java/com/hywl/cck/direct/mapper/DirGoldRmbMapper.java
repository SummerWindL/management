package com.hywl.cck.direct.mapper;

import java.util.List;
import java.util.Map;

import com.hywl.cck.direct.entity.DirGoldRmb;

public interface DirGoldRmbMapper {
    int deleteByPrimaryKey(String giftGoldId);

    int insert(DirGoldRmb record);

    int insertSelective(DirGoldRmb record);

    DirGoldRmb selectByPrimaryKey(String giftGoldId);

    int updateByPrimaryKeySelective(DirGoldRmb record);

    int updateByPrimaryKey(DirGoldRmb record);
    
    /**
    *
    * 查询
    *
    * @param map
    * @return
    */
   public List<Map<String, Object>> selectGoldRmbList(Map<String, Object> map);
   
}