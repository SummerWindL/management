package com.hywl.cck.shiro.service;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.shiro.entity.SysUserInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 16:11 2017/11/16
 */
public interface SysUserInfoService {

    /**
     *
     * 通过用户名获取系统用户
     *
     * @param userName 用户名
     * @return
     */
    public SysUserInfo getSysUserByName(String userName);

    /**
     *
     * 获取用户分页列表
     *
     * @param map
     * @return
     */
    public PageInfo<Map<String, Object>> selectUserList(Map<String, Object> map);


    /**
     *
     * 更新
     *
     * @param record
     * @return
     */
    public int update(SysUserInfo record);


    /**
     *
     * 添加
     *
     * @param record
     * @return
     */
    public int add(SysUserInfo record);

    /**
     *
     * 获取用户信息
     *
     * @param userSn 用户编号
     * @return
     */
    public SysUserInfo get(String userSn);

    /**
     *
     * 获取用户的权限列表
     *
     * @param userSn 用户编号
     * @return
     */
    public List<String> getPermissionList(String userSn);
}
