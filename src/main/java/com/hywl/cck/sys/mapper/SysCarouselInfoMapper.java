package com.hywl.cck.sys.mapper;

import java.util.List;
import java.util.Map;


/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 18:07 2017/11/7
 */
public interface SysCarouselInfoMapper {


    /**
     * 分页显示主页信息
     * @param map
     * @return
     */
    List<Map<String,Object>> selectAllPictureList(Map<String, Object> map);
    
    
}
