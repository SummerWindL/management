package com.hywl.cck.shiro.realmx;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hywl.cck.shiro.entity.SysUserInfo;
import com.hywl.cck.shiro.service.SysUserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserInfoService sysUserInfoService;

    /**  
     * 登录验证  
     */ 
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken//令牌——基于用户名和密码的令牌
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2. 从 UsernamePasswordToken 中来获取 username//令牌中可以取出用户名
        String username = upToken.getUsername();

        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        SysUserInfo sysUserInfo = sysUserInfoService.getSysUserByName(username);

        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (sysUserInfo == null) {
            throw new UnknownAccountException("用户不存在或者密码错误");
        }
        if (sysUserInfo.getUserStatus().equals("1")) {
            throw new LockedAccountException("用户被停用");
        }
        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
        if (sysUserInfo.getUserStatus().equals("2")) {
            throw new LockedAccountException("用户被删除");
        }

        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = sysUserInfo;
        //2). credentials: 密码.
        Object credentials = sysUserInfo.getPassword(); //从数据库查询的密码

        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4). 盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(sysUserInfo.getUserSn());

        SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
        // ①：认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        //②：数据库查询的密码
        //③：盐值
        //④:认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("user15431");
        ;
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }

    //授权会被 shiro 回调的方法。 当jsp页面出现shiro标签时，就会执行授权方法 // 为当前用户授予权限 
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
//        System.out.println("shiro 回调的方法====");
        //1. 从 PrincipalCollection 中来获取登录用户的信息
        SysUserInfo principal = (SysUserInfo) principals.getPrimaryPrincipal();

        //2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        Set<String> permissions = new HashSet<>();
        List<String> permissonList = sysUserInfoService.getPermissionList(principal.getUserSn());
        if (permissonList != null && permissonList.size() > 0) {
            for (String str : permissonList) {
                permissions.add(str);
            }
        }
        //3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);

        //4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }
}
