package com.hywl.cck.shiro.controller.admin;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.admin.Result;
import com.hywl.cck.base.controller.BaseAdminController;
import com.hywl.cck.shiro.service.SysRoleService;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 19:00 2017/11/17
 */
@Controller
@RequestMapping("admin/sysRole")
public class SysRoleAdminController extends BaseAdminController {


	@Autowired
	public SysRoleService sysRoleService;
	
    /**
     * 返回角色列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList() {

        return "sys/sysUser/role/roleList";
    }
    
    /**
     * 获取角色列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getSysRoleList")
    @ResponseBody
    public Result getSysRoleList(@RequestParam(value ="pageNum",defaultValue ="1") Integer pageNum,
    		@RequestParam(value = "pageSize" ,defaultValue = "20") Integer pageSize) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("pageNum", pageNum);
    	map.put("pageSize", pageSize);
    	PageInfo<Map<String, Object>> sysRoleList = sysRoleService.getSysRoleList(map);
    	return Result.success(sysRoleList);
    }
   
}