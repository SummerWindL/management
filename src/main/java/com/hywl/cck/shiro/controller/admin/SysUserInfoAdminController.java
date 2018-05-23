package com.hywl.cck.shiro.controller.admin;

import com.hywl.cck.base.admin.Result;
import com.hywl.cck.base.controller.BaseAdminController;
import com.hywl.cck.base.unit.db.PwdUtil;
import com.hywl.cck.base.unit.smart.StringUtils;
import com.hywl.cck.shiro.entity.SysUserInfo;
import com.hywl.cck.shiro.service.SysUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 16:11 2017/11/16
 */
@Controller
@RequestMapping("admin/sysUserInfo")
public class SysUserInfoAdminController extends BaseAdminController {

    @Resource
    private SysUserInfoService sysUserInfoService;

    /**
     * 用户后台登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result login(HttpSession httpSession,String userName, String password) {
        if (StringUtils.isBlank(userName)) {
            return Result.error("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return Result.error("密码不能为空");
        }
        // 用户登录的时候返回再次输入错误密码的时候报错  AuthenticationException，暂时先在这里判断用户名和密码start
        SysUserInfo sysUserInfo = sysUserInfoService.getSysUserByName(userName);
        if (sysUserInfo == null) {
            return Result.error("用户不存在或者密码错误");
        }
        if (sysUserInfo.getUserStatus().equals("1")) {
            return Result.error("用户被停用");
        }
        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
        if (sysUserInfo.getUserStatus().equals("2")) {
            return Result.error("用户被删除");
        }
        String pwd = PwdUtil.getPwd(sysUserInfo.getUserSn(), password);
        if (!pwd.equals(sysUserInfo.getPassword())) {
            return Result.error("用户不存在或者密码错误");
        }
        // 判断end

        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);
            try {
                // 执行登录.
                currentUser.login(token);
            } catch (AuthenticationException e) {
                return Result.error(e.getMessage());
            } catch (Exception e) {
                return Result.error(e.getMessage());
            }
        }
        setSession(httpSession, userName);
        return Result.success("登录成功");
    }

    
    /**
     * 返回用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList() {

        return "sys/sysUser/userInfo/sysUserInfoList";
    }
}