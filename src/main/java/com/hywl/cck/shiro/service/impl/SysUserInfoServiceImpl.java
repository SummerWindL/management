package com.hywl.cck.shiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.constant.ConstantBean;
import com.hywl.cck.base.unit.db.IdWorkerAide;
import com.hywl.cck.base.unit.db.PwdUtil;
import com.hywl.cck.base.unit.db.TablePrefixUtil;
import com.hywl.cck.base.unit.smart.StringUtils;
import com.hywl.cck.shiro.entity.SysUserInfo;
import com.hywl.cck.shiro.mapper.SysUserInfoMapper;
import com.hywl.cck.shiro.service.SysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 16:11 2017/11/16
 */
@Service("sysUserInfoService")
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Resource
    private SysUserInfoMapper sysUserInfoMapper;

    /**
     *
     * 通过用户名获取系统用户
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public SysUserInfo getSysUserByName(String userName) {
        return this.sysUserInfoMapper.getSysUserByName(userName);
    }

    /**
     *
     * 获取用户分页列表
     *
     * @param map
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> selectUserList(Map<String, Object> map) {
        PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
        List<Map<String, Object>> list = this.sysUserInfoMapper.selectUserList(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list == null ? new ArrayList<>() : list);
        return pageInfo;
    }

    /**
     *
     * 更新
     *
     * @param record
     * @return
     */
    @Override
    public int update(SysUserInfo record) {
        record.setModifyTime(new Date());
        return this.sysUserInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     *
     * 添加
     *
     * @param record
     * @return
     */
    @Override
    public int add(SysUserInfo record) {
        String userSn = TablePrefixUtil.sys_user_info + String.valueOf(IdWorkerAide.nextId());
        record.setModifyTime(new Date());
        record.setCreateTime(new Date());
        record.setUserSn(userSn);
        String password = PwdUtil.getPwd(userSn, ConstantBean.PASSWORD_DEFALUT); // 加密的密码
        record.setPassword(password);
        return this.sysUserInfoMapper.insertSelective(record);
    }

    /**
     *
     * 获取用户信息
     *
     * @param userSn 用户编号
     * @return
     */
    @Override
    public SysUserInfo get(String userSn) {
        return this.sysUserInfoMapper.selectByPrimaryKey(userSn);
    }

    /**
     *
     * 获取用户的权限列表
     *
     * @param userSn 用户编号
     * @return
     */
    @Override
    public List<String> getPermissionList(String userSn) {
        if (StringUtils.isBlank(userSn)) {
            return null;
        }
        List<String> roleList = this.sysUserInfoMapper.getRoleList(userSn);
        if (roleList != null && roleList.size() > 0) {
            List<String> perssionList = this.sysUserInfoMapper.getPermissonList(roleList);
            return perssionList;
        }

        return null;
    }
}