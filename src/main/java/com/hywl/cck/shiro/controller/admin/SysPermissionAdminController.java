package com.hywl.cck.shiro.controller.admin;

import com.hywl.cck.base.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 15:19 2017/11/18
 */
@Controller
@RequestMapping("admin/sysPermission")
public class SysPermissionAdminController extends BaseAdminController {


    /**
     * 返回权限列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList() {

        return "sys/sysUser/sysPermission/sysPermissionList";
    }

}