package com.hywl.cck.sys.controller.admin;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.admin.Result;
import com.hywl.cck.base.controller.BaseAdminController;
import com.hywl.cck.sys.service.SysCarouselInfoService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: xiao
 * \* Date: 2017/11/21
 * \* Time: 19:19
 * \
 */
@Controller
@RequestMapping(value = "/admin")
public class CarouselInfoController extends BaseAdminController {

    
	@Resource
    private SysCarouselInfoService sysCarouselInfoService;
	
    /***
     * 返回图片查询页面
     * @return
     */
    @RequestMapping(value = "/toList")
    public String toList(){
    	return "home/pictureList";
    }

    /**
     * app主页信息 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="home/picturelist")
    @ResponseBody
    public Result pictureList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        PageInfo<Map<String, Object>> pageInfo=sysCarouselInfoService.selectAllPictureList(map);
        return Result.success(pageInfo);
    }
    
}
