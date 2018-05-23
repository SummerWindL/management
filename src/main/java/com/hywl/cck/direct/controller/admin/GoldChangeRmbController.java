package com.hywl.cck.direct.controller.admin;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.admin.Result;
import com.hywl.cck.base.controller.BaseAdminController;
import com.hywl.cck.direct.service.DirGoldRmbService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/***
 * 金币兌换人民币
 * @author xiao
 *
 */
@Api("admin/goldRmb")
@Controller
@RequestMapping("admin/goldRmb")  
public class GoldChangeRmbController extends BaseAdminController{
	
	@Resource
	private DirGoldRmbService dirGoldRmbService;
	
	/***
	 * 跳转到金币兌换人民币查询页面
	 * @return
	 */
	@RequestMapping(value = "/toList")
	public String toList(){
		return "direct/goldChangeRmb/goldChangeRmbList";
	}
	
	/**
     * 查询金币兌换人民币
     *
     * @param pageNum      开始的页数
     * @param pageSize     每页的行数
     * @param categoryName 购买人名称
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    @ApiOperation(value="查询金币兑换人民币",httpMethod="GET",notes="get user by id",response=Result.class)
    public Result list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	 map.put("pageNum", pageNum);
         map.put("pageSize", pageSize);
         PageInfo<Map<String, Object>> pageInfo = dirGoldRmbService.selectGoldRmbList(map);
        return Result.success(pageInfo);
    }
	
}
