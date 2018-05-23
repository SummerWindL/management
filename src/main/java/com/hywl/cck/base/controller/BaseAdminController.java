package com.hywl.cck.base.controller;

import com.hywl.cck.shiro.entity.SysUserInfo;
import com.hywl.cck.shiro.service.SysUserInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 16:16 2017/11/16
 */
public class BaseAdminController {
    @Resource
    private SysUserInfoService sysUserInfoService;

    protected String getLoginName(HttpSession httpSession) {
        return getSessionSysUserInfo(httpSession) == null ? "未知用户名" : getSessionSysUserInfo(httpSession).getUserName();
    }

    protected void setSession(HttpSession httpSession, String userName) {
        SysUserInfo sysUserInfo = sysUserInfoService.getSysUserByName(userName);
        sysUserInfo.setLoginCount(sysUserInfo.getLoginCount() == null ? 1 : sysUserInfo.getLoginCount() + 1);
        sysUserInfoService.update(sysUserInfo);
        httpSession.setAttribute("sys-admin", sysUserInfo);
    }


    protected SysUserInfo getSessionSysUserInfo(HttpSession httpSession) {
        SysUserInfo sysUserInfo = httpSession.getAttribute("sys-admin") == null ? null : (SysUserInfo) httpSession.getAttribute("sys-admin");
        return sysUserInfo;
    }
}