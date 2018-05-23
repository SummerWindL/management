package com.hywl.cck.user.service;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.user.entity.UserInfo;

import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 9:58 2017/10/30
 */
public interface UserInfoService {

    /**
     * 查询所有用户
     * @return
     */
    public PageInfo<Map<String, Object>> selectAllUser(Map<String, Object> map);
 
   
}
