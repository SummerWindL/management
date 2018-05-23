package com.hywl.cck.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywl.cck.sys.mapper.SysCarouselInfoMapper;
import com.hywl.cck.sys.service.SysCarouselInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 18:07 2017/11/7
 */
@Service("sysCarouselInfoService")
public class SysCarouselInfoServiceImpl implements SysCarouselInfoService {

    @Resource
    private SysCarouselInfoMapper sysCarouselInfoMapper;

    /***
     * 查询主页信息
     */
    @Override
    public PageInfo<Map<String, Object>> selectAllPictureList( Map<String, Object> map) {
        PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
        List<Map<String, Object>> list = this.sysCarouselInfoMapper.selectAllPictureList(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>((list == null) ? new ArrayList<>() : list);
        return pageInfo;
    }
    

}