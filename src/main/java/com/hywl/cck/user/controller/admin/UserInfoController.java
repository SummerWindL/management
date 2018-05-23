package com.hywl.cck.user.controller.admin;


import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.admin.Result;
import com.hywl.cck.base.controller.BaseAdminController;
import com.hywl.cck.user.service.UserInfoService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping(value ="admin/")
public class UserInfoController extends BaseAdminController{

	 @Autowired
	 private UserInfoService userInfoService;
	 
    /**
     * 跳转用户列表页面
     * @return
     */
    @RequestMapping(value = "userlist")
    public String showList() {
        return "user/userList";
    }
    
    /**
     * 用户列表显示（所有参数可以不输入）
     * @param pageNum 页数 默认值 1
     * @param pageSize 每页显示条数 默认值 20
     * @param userName 用户昵称
     * @param mobile 手机
     * @param userStatus 用户状态 0 表示禁用 1 表示启用
     * @return
     */
    @RequestMapping(value ="user/list")
    @ResponseBody
    public Result userList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                           String userName, String mobile, String userStatus){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("userName", userName);
        map.put("mobile", mobile);
        map.put("userStatus", userStatus);

        PageInfo<Map<String, Object>> pageInfo=userInfoService.selectAllUser(map);
        return Result.success(pageInfo);
    }
    
    

    
}
