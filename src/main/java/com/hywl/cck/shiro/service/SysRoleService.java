package com.hywl.cck.shiro.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 * SysRole service
 * @author yanl
 *
 */
public interface SysRoleService {

	/**
	 * 查询权限列表 
	 * @param map
	 * @return
	 */
	PageInfo<Map<String, Object>> getSysRoleList(Map<String,Object> map);
}
