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
import com.hywl.cck.management.entity.ProductInfo;
import com.hywl.cck.management.service.BrankInfoService;
import com.hywl.cck.management.service.ProductInfoService;

@Controller
@RequestMapping("web/product")
public class ProductController extends BaseWapController{
	
    @Resource
    private BrankInfoService brankInfoService;
    
    @Resource
    private ProductInfoService productInfoService;


	/**
     * 删除一个品牌
     * @param id 品牌id
     * @param brankName 品牌名称
     * @return
     */
    @RequestMapping(value = "/deleteBrank", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrank(Integer id,String brankName) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(brankName)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }
			else {
                    ProductInfo productInfo = productInfoService.getProductByBrankId(id);
                    if (productInfo != null) {
                        commonEnums = CommonEnums.BRANK_ISONPRODUCT; // 100 该品牌已有商品上架,不能删除
                    } else {
                    	brankInfoService.deleteBrank(brankName);
                        
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
  
}
