package com.hywl.cck.management.controller.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hywl.cck.base.bean.Result;
import com.hywl.cck.base.controller.BaseWapController;
import com.hywl.cck.base.enums.CommonEnums;
import com.hywl.cck.base.unit.smart.StringUtils;
import com.hywl.cck.management.entity.BrankInfo;
import com.hywl.cck.management.entity.ProductInfo;
import com.hywl.cck.management.service.BrankInfoService;
import com.hywl.cck.management.service.ProductInfoService;


@Controller
@RequestMapping("web/merchant")
public class BrankController extends BaseWapController{
    @Resource
    private BrankInfoService brankInfoService;
    
    @Resource
    private ProductInfoService productInfoService;
	
	/**
     * 添加新品牌
     *
     * @param brankName 品牌名称
     * @return
     */
    @RequestMapping(value = "/addBrank", method = RequestMethod.POST)
    @ResponseBody
    public Result addBrank(String brankName) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(brankName)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }
			else {
                    BrankInfo brankInfo = brankInfoService.getBrank(brankName);
                    if (brankInfo != null) {
                        commonEnums = CommonEnums.BRANK_EXIT; // 100 该手机号码已注册，不能重新注册
                    } else {
                    	brankInfo = brankInfoService.addBrankInfo(brankName);
                        r.setData(brankInfo);
                        commonEnums = CommonEnums.SUCCESS; // 301 成功
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
     * 获取品牌列表
     *
     * @return
     */
    @RequestMapping(value = "/getAllBrankList", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllBrankList() {
        Result r = new Result();
        try {
            List<Map<String, Object>> list = brankInfoService.getBrankList();
            if (list == null || list.size() == 0) {
                commonEnums = CommonEnums.NOT_AVAILABLE_DATA; // 304 暂无数据
            } else {

                r.setData(list);
                commonEnums = CommonEnums.SUCCESS; // 301 成功
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
