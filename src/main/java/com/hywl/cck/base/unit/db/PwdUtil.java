package com.hywl.cck.base.unit.db;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: yzw
 * @Description: 使用盐值加密1024次md5
 * @Date: Create in 11:42 2017/11/17
 */
public class PwdUtil {

    /**
     *
     * 密码加密
     *
     * @param saltValue 盐值
     * @param pwd 要加密的密码
     * @return
     */
    public static String getPwd(String saltValue, String pwd) {
        String hashAlgorithmName = "MD5";
        Object salt = ByteSource.Util.bytes(saltValue);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, pwd, salt, hashIterations);
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String str = getPwd("123", "123456");
        System.out.println(str);
    }
}