package com.hywl.cck.shiro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywl.cck.shiro.entity.SysRole;
import com.hywl.cck.shiro.mapper.SysRoleMapper;
import com.hywl.cck.shiro.service.SysRoleService;

/**
 * @author yanl
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	
	@Autowired
	public SysRoleMapper sysRoleMapper;


	/**
	 * 获取角色信息列表
	 */
	@Override
	public PageInfo<Map<String, Object>> getSysRoleList(Map<String, Object> map) {
		PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
		List<Map<String,Object>> list = sysRoleMapper.getSysRoleList(map);
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>(list != null ? list : new ArrayList<>());
		
		return pageInfo;
	}
}
