package com.hywl.cck.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywl.cck.user.mapper.UserInfoMapper;
import com.hywl.cck.user.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 9:58 2017/10/30
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     *   显示所有的用户信息
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>>selectAllUser(Map<String, Object> map) {

        PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
        List<Map<String, Object>> list = this.userInfoMapper.selectAllUser(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>((list == null) ? new ArrayList<>() : list);
        return pageInfo;

    }




}