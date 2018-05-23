package com.hywl.cck.user.mapper;

import com.hywl.cck.user.entity.UserInfo;

import java.util.List;
import java.util.Map;


/**
 * @Author: yzw
 * @Description:
 * @Date: Create in 9:54 2017/10/30
 */
public interface UserInfoMapper {
	

    /**
     *
     * 通过手机号码获取用户信息
     *
     * @param mobileNubmer 手机号码
     * @return
     */
    public UserInfo getByMobileNumber(String mobileNubmer);

    /**
     *
     * 插入数据
     *
     * @param record
     */
    public void insertSelective(UserInfo record);

    /**
     *
     * 获取用户信息
     *
     * @param userInfoId
     * @return
     */
    public UserInfo selectByPrimaryKey(String userInfoId);


    /**
     *更新用户信息
     * @return  修改成功  返回 1
     */
    public int updateInfo(UserInfo info);
    
    /**
     *更新用户余额
     * @return  
     */
    public int updateInfoTotal(Map<String,Object> map);

    /**
     *
     * 通过账号id获取用户信息
     *
     * @param accountId 账号id（唯一性）
     * @return
     */
    public UserInfo getUserByAccountId(String accountId);


    /**
     * 显示所有用户信息
     * @return
     */
    public List<Map<String, Object>> selectAllUser(Map<String ,Object> map);


    /**
     * 批量
     * @param userInfoIDs
     * @return
     */
    public int updateIsEnable(String [] userInfoIDs);



    public int userEnable(String str);

    public int disabled(String str);
    
    
}