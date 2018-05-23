package com.hywl.cck.management.controller.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hywl.cck.base.bean.Result;
import com.hywl.cck.base.controller.BaseWapController;
import com.hywl.cck.base.enums.CommonEnums;
import com.hywl.cck.base.unit.smart.StringUtils;
import com.hywl.cck.base.unit.smart.ValidateUtils;
import com.hywl.cck.management.entity.MerchantInfo;
import com.hywl.cck.management.service.MerchantInfoService;




@Controller
@RequestMapping("web/merchant")
public class MerchantController extends BaseWapController {

    @Resource
    private MerchantInfoService merchantInfoService;


    /**
     * 注册时根据手机号码判断是否存在用户
     *
     * @param mobileNumber
     * @return
     */
    @RequestMapping(value = "/merchantIsExist", method = RequestMethod.POST)
    @ResponseBody
    public Result merchantIsExist(String mobileNumber) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(mobileNumber)) {
                commonEnums = CommonEnums.PARAMETER_ERROR; // 300 参数错误
            } else {
                if (!ValidateUtils.isMobile(mobileNumber)) {
                    commonEnums = CommonEnums.MOBILE_ERROR; // 303 手机号码格式不正确
                } else {
                    MerchantInfo merchantInfo = merchantInfoService.getMerchantByPhoneNumber(mobileNumber);
                    if (merchantInfo != null) {
                        commonEnums = CommonEnums.REGISTER_ACCOUNT_EXIST; // 100 该手机号码已注册，不能重新注册
                    } else {
                        commonEnums = CommonEnums.SUCCESS; // 301 成功
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonEnums = CommonEnums.SYSTEM_ERROR; // 302 系统错误
        } finally {
            r.setStatus(commonEnums.getValue());
            r.setMessage(commonEnums.getLabel());
        }
        return r;
    }
    
    
    /**
     * 生成商户保存信息
     *
     * @param mobileNumber 手机号码
     * @param  merchantName 商家名称
     * @param linksman     联系人
     * @param idCard     身份证号
     * @param merchantType     状态  (0:禁用  1.开启)
     * @return
     */
    @RequestMapping(value = "/saveMerchantInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result saveMerchantInfo(String mobileNumber, String merchantName, String linksman, String idCard, String merchantType) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(mobileNumber)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }else if(StringUtils.isBlank(merchantName)){
            	commonEnums = CommonEnums.MERCHANT_NAME_ERROR;
			}else if(StringUtils.isBlank(linksman)){
            	commonEnums = CommonEnums.LINKMAN_ERROR;
			}else if(StringUtils.isBlank(idCard)){
            	commonEnums = CommonEnums.ENTER_CODES;
			}else if(StringUtils.isBlank(merchantType)){
            	commonEnums = CommonEnums.ENTER_CODES;
			}
			else {
                if (!ValidateUtils.isMobile(mobileNumber)) {
                    commonEnums = CommonEnums.MOBILE_ERROR; // 303 手机号码格式不正确
                } else {

                            MerchantInfo merchantInfo = merchantInfoService.getMerchantByPhoneNumber(mobileNumber);
                            if (merchantInfo != null) {
                                commonEnums = CommonEnums.REGISTER_ACCOUNT_EXIST; // 100 该手机号码已注册，不能重新注册
                            } else {
                            	merchantInfo = merchantInfoService.register(mobileNumber,merchantName,linksman,idCard,merchantType);
//                            	
//                                
                                r.setData(merchantInfo);
                                commonEnums = CommonEnums.SUCCESS; // 301 成功
                            }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonEnums = CommonEnums.SYSTEM_ERROR; // 302 系统错误
        } finally {
            r.setStatus(commonEnums.getValue());
            r.setMessage(commonEnums.getLabel());
        }
        return r;
    }
    
    
    
    
    

}






