package com.hywl.cck.sys.service;

import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 18:07 2017/11/7
 */
public interface SysCarouselInfoService {
	
	
    /**
     *
     * 查询主页信息
     *
     * @return
     */
    public PageInfo<Map<String, Object>> selectAllPictureList(Map<String, Object> map);



}
