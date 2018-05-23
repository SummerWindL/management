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
import com.hywl.cck.management.entity.FirstCategoryInfo;
import com.hywl.cck.management.entity.ProductInfo;
import com.hywl.cck.management.entity.SecondCategoryInfo;
import com.hywl.cck.management.service.FirstCategoryInfoService;
import com.hywl.cck.management.service.SecondCategoryInfoService;


@Controller
@RequestMapping("web/oneCategory")
public class FirstCategoryController extends BaseWapController{
	@Resource
	private FirstCategoryInfoService oneCategoryInfoService;
	@Resource
	private SecondCategoryInfoService secCategoryInfoService;
	
	
	
	/**
     * 添加新类别
     *
     * @param categoryName 类别名称
     * @return
     */
    @RequestMapping(value = "/addOneCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result addOneCategory(String categoryName) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(categoryName)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }
			else {
				FirstCategoryInfo oneCategoryInfo = oneCategoryInfoService.getOneCategory(categoryName);
                    if (oneCategoryInfo != null) {
                        commonEnums = CommonEnums.CATEGORY_ISEXIT; // 706 该类别已存在,请不要重复增加
                    } else {
                    	oneCategoryInfo = oneCategoryInfoService.addCategoryInfo(categoryName);
                        r.setData(categoryName);
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
     * 获取类别列表
     *
     * @return
     */
    @RequestMapping(value = "/getAllCategoryList", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllCategoryList() {
        Result r = new Result();
        try {
            List<Map<String, Object>> list = oneCategoryInfoService.getCategoryList();
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
     * 删除一个类别
     * @param categoryId 类别id
     * @param categoryName 类别名称
     * @return
     */
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBrank(Integer categoryId,String categoryName) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(categoryName)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }
			else {
                    SecondCategoryInfo secondCategoryInfo = secCategoryInfoService.getCategoryInfo(categoryId);
                    if (secondCategoryInfo != null) {
                        commonEnums = CommonEnums.SECOND_CATEGORY_ISEXIT; // 707 该类别已有二级分类,不能删除
                    } else {
                    	oneCategoryInfoService.deletcategoryById(categoryId);
                        
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
     * 将一个一级类别上移
     * @param id    
     * @param stortId 
     * @return
     */
    @RequestMapping(value = "/upFirstCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result upFirstCategory(Integer id,Integer stortId) {
        Result r = new Result();
        try {
//            if (StringUtils.isBlank(categoryName)) {
//                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
//            }
//			else {
                    FirstCategoryInfo firstCategoryInfo = oneCategoryInfoService.getFirstcategoryById(stortId);
                    if (firstCategoryInfo != null) {
                    	FirstCategoryInfo updateInfo = new FirstCategoryInfo();
                    	updateInfo.setId(id);
                    	updateInfo.setStortId(firstCategoryInfo.getStortId());
                    	oneCategoryInfoService.updateFirstCagegoryInfo(updateInfo);
                    	
                    	
                    	FirstCategoryInfo downdateInfo = new FirstCategoryInfo();
                    	downdateInfo.setId(firstCategoryInfo.getId());
                    	downdateInfo.setStortId(stortId);
                    	oneCategoryInfoService.updateFirstCagegoryInfo(downdateInfo);
                    	
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
     * 将一个一级类别下移
     * @param id    
     * @param stortId 
     * @return
     */
    @RequestMapping(value = "/downFirstCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result downFirstCategory(Integer id,Integer stortId) {
        Result r = new Result();
        try {
//            if (StringUtils.isBlank(categoryName)) {
//                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
//            }
//			else {
                    FirstCategoryInfo firstCategoryInfo = oneCategoryInfoService.getgoryById(stortId);
                    if (firstCategoryInfo != null) {
                    	FirstCategoryInfo updateInfo = new FirstCategoryInfo();
                    	updateInfo.setId(id);
                    	updateInfo.setStortId(firstCategoryInfo.getStortId());
                    	oneCategoryInfoService.updateFirstCagegoryInfo(updateInfo);
                    	
                    	
                    	FirstCategoryInfo downdateInfo = new FirstCategoryInfo();
                    	downdateInfo.setId(firstCategoryInfo.getId());
                    	downdateInfo.setStortId(stortId);
                    	oneCategoryInfoService.updateFirstCagegoryInfo(downdateInfo);
                    	
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
    
    /**
     * 更新一级类别信息
     * @param id    id号
     * @param categoryName  更新的内容
     * @return
     */
    @RequestMapping(value = "/updateFCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result updateFCategory(Integer id,String categoryName) {
        Result r = new Result();
        try {
            if (StringUtils.isBlank(categoryName)) {
                commonEnums = CommonEnums.ENTER_MOBILENUMBER; // 300 参数错误
            }
			else {
				FirstCategoryInfo oneCategoryInfo = oneCategoryInfoService.getOneCategory(categoryName);
                   if (oneCategoryInfo != null) {
                	   commonEnums = CommonEnums.CATEGORY_ISEXIT; // 706 该类别已存在,请不要重复增加
                   }else{
                    	FirstCategoryInfo updateInfo = new FirstCategoryInfo();
                    	updateInfo.setId(id);
                    	updateInfo.setCategoryName(categoryName);
                    	oneCategoryInfoService.updateFirstCagegoryInfo(updateInfo);
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
     * 删除一级类别信息
     * @param id 一级类别id号
     * @return
     */
    @RequestMapping(value = "/deleteFCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteFCategory(Integer id) {
    	Result result = new Result();
    	try {
    		SecondCategoryInfo secondCategoryInfo = secCategoryInfoService.getCategoryInfo(id);
    		if (secondCategoryInfo != null) {
                commonEnums = CommonEnums.SECOND_CATEGORY_ISEXIT; // 700 该类别已有二级分类,不能删除
            } else {
            	oneCategoryInfoService.deletcategoryById(id);
                
                commonEnums = CommonEnums.SUCCESS; // 301 成功
            }
		} catch (Exception e) {
			e.printStackTrace();
			commonEnums = CommonEnums.SYSTEM_ERROR; // 302 系统错误
		} finally {
			result.setStatus(commonEnums.getValue());
			result.setMessage(commonEnums.getLabel());
		}
		return result;
    	
    }
    
}


