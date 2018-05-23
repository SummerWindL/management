package com.hywl.cck.game.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.admin.Result;
import com.hywl.cck.game.service.GameListService;



/**
 * \* Created with IntelliJ IDEA.
 * \* User: xiao
 * \* Date: 2017/11/22
 * \* Time: 19:23
 * \
 */
@Controller
@RequestMapping(value = "/admin")
public class GameController {

	@Autowired
    private GameListService gameListService;
	
    /**
     * 跳转游戏列表
     * @return
     */
    @RequestMapping(value = "/game/showGame")
    public String showGame(){
        return "game/gameInfo";
    }
    
    /**
     * 游戏列表显示
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="game/gameList")
    @ResponseBody
    public Result userList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);

        PageInfo<Map<String, Object>> pageInfo=gameListService.selectAllUser(map);
        return Result.success(pageInfo);
    }

}
