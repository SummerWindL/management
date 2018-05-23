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
import com.hywl.cck.direct.service.DirectGiftInfoService;

/***
 * 直播礼物信息
 * @author xiao
 *
 */
@Controller
@RequestMapping("admin/liveList")
public class DirectGiftInfoController extends BaseAdminController{
	
	@Resource
	private DirectGiftInfoService directGiftInfoService;
	
	/***
	 * 跳转到直播礼物信息查询页面
	 * @return
	 */
	@RequestMapping(value = "/toList")
	public String toList(){
		return "direct/giftInfo/giftInfoList";
	}
	
	/**
     * 查询直播礼物信息
     *
     * @param pageNum      开始的页数
     * @param pageSize     每页的行数
     * @param categoryName 购买人名称
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	 map.put("pageNum", pageNum);
         map.put("pageSize", pageSize);
         PageInfo<Map<String, Object>> pageInfo = directGiftInfoService.selectGiftInfoList(map);
        return Result.success(pageInfo);
    }
    
}
