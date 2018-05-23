package com.hywl.cck.shiro.mapper;

import com.hywl.cck.shiro.entity.SysUserInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 16:11 2017/11/16
 */
public interface SysUserInfoMapper {

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
    public List<Map<String, Object>> selectUserList(Map<String, Object> map);

    /**
     *
     * 更新
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(SysUserInfo record);

    /**
     *
     * 插入
     *
     * @param record
     * @return
     */
    public int insertSelective(SysUserInfo record);

    /**
     *
     * 获取用户信息
     *
     * @param userSn 用户编号
     * @return
     */
    public SysUserInfo selectByPrimaryKey(String userSn);

    /**
     *
     * 获取角色列表
     *
     * @param userSn
     * @return
     */
    public List<String> getRoleList(String userSn);

    /**
     *
     * 获取权限列表
     *
     * @param list 角色list
     * @return
     */
    public List<String> getPermissonList(List<String> list);
}
