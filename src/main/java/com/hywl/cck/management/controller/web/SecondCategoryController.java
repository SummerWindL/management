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
import com.hywl.cck.management.entity.ProductInfo;
import com.hywl.cck.management.entity.SecondCategoryInfo;
import com.hywl.cck.management.service.ProductInfoService;
import com.hywl.cck.management.service.SecondCategoryInfoService;

@Controller
@RequestMapping("web/secondCategory")
public class SecondCategoryController extends BaseWapController{
	
	@Resource
	private SecondCategoryInfoService secCateInfoService;
	
    @Resource
    private ProductInfoService productInfoService;
	
	/**
     * 添加二级新类别
     * @param firstcategoryId 一级类别id
     * @param secCategoryName 二级类别名称
     * @return
     */
    @RequestMapping(value = "/addSecondCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result addOneCategory(Integer firstcategoryId,String secCategoryName) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(secCategoryName)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }
			else {
				    SecondCategoryInfo secCategoryInfo = secCateInfoService.getSecCategoryByName(secCategoryName);
                    if (secCategoryInfo != null) {
                        commonEnums = CommonEnums.CATEGORY_ISEXIT; // 706 该类别已存在,请不要重复增加
                    } else {
                    	secCategoryInfo = secCateInfoService.addSecCategory(firstcategoryId,secCategoryName);
                        r.setData(secCategoryInfo);
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
     * 获取二级类别列表
     *
     * @return
     */
    @RequestMapping(value = "/getSecCategoryList", method = RequestMethod.POST)
    @ResponseBody
    public Result getSecCategoryList() {
        Result r = new Result();
        try {
            List<Map<String, Object>> list = secCateInfoService.getSecCategoryList();
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
    
    /**
     * 删除一个二级类别
     * @param categoryId 二级类别id
     * @return
     */
    @RequestMapping(value = "/deleteSecondCate", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrank(Integer categoryId) {
        Result r = new Result();
        try {
//            if (StringUtils.isBlank(categoryName)) {
//                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
//            }
//			else {
                    ProductInfo productInfo = productInfoService.getProductByCategoryId(categoryId);
                    if (productInfo != null) {
                        commonEnums = CommonEnums.PRODUCT_BY_CATEGORY; // 100 该类别已有商品上架,不能删除
                    } else {
                    	secCateInfoService.deletSeccategoryById(categoryId);
                        
                        commonEnums = CommonEnums.SUCCESS; // 301 成功
                    }
//            }
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
     * 将一个二级类别上移
     * @param id    
     * @param stortId 
     * @return
     */
    @RequestMapping(value = "/upSecondCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result upSecondCategory(Integer id,Integer stortId) {
        Result r = new Result();
        try {
//            if (StringUtils.isBlank(categoryName)) {
//                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
//            }
//			else {
                    SecondCategoryInfo secondCategoryInfo = secCateInfoService.getSeccategoryById(stortId);
                    if (secondCategoryInfo != null) {
                    	SecondCategoryInfo updateInfo = new SecondCategoryInfo();
                    	updateInfo.setId(id);
                    	updateInfo.setStortId(secondCategoryInfo.getStortId());
                    	secCateInfoService.updateCagegoryInfo(updateInfo);
                    	
                    	
                    	SecondCategoryInfo downdateInfo = new SecondCategoryInfo();
                    	downdateInfo.setId(secondCategoryInfo.getId());
                    	downdateInfo.setStortId(stortId);
                    	secCateInfoService.updateCagegoryInfo(downdateInfo);
                    	
                    	commonEnums = CommonEnums.SUCCESS; // 301 成功
                    } else {
                        
                        commonEnums = CommonEnums.CATEGORY_ISNUMBERONE; // 709 该类别已是第一条,不能上移
                    }
//            }
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
     * 将一个二级类别下移
     * @param id    
     * @param stortId 
     * @return
     */
    @RequestMapping(value = "/downSecondCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result downSecondCategory(Integer id,Integer stortId) {
        Result r = new Result();
        try {
//            if (StringUtils.isBlank(categoryName)) {
//                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
//            }
//			else {
                    SecondCategoryInfo secondCategoryInfo = secCateInfoService.getgoryById(stortId);
                    if (secondCategoryInfo != null) {
                    	SecondCategoryInfo updateInfo = new SecondCategoryInfo();
                    	updateInfo.setId(id);
                    	updateInfo.setStortId(secondCategoryInfo.getStortId());
                    	secCateInfoService.updateCagegoryInfo(updateInfo);
                    	
                    	
                    	SecondCategoryInfo downdateInfo = new SecondCategoryInfo();
                    	downdateInfo.setId(secondCategoryInfo.getId());
                    	downdateInfo.setStortId(stortId);
                    	secCateInfoService.updateCagegoryInfo(downdateInfo);
                    	
                    	commonEnums = CommonEnums.SUCCESS; // 301 成功
                    } else {
                        
                        commonEnums = CommonEnums.CATEGORY_ISEND; // 710 该类别已是最后一条,不能下移
                    }
//            }
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
