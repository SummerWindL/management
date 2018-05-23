package com.hywl.cck.game.service;

import com.github.pagehelper.PageInfo;
import com.hywl.cck.game.entity.GameList;

import java.util.List;
import java.util.Map;

public interface GameListService {


    /**
     * 获取 游戏信息列表
     * @return
     */
    List<Map<String,Object>> getGameInfoList(int type);


    /**
     * 获取指定ID的游戏信息
     * @param gameID
     * @return
     */
    GameList getGameInfo(String gameID);

    /**
     * 查询所有的游戏
     * @param map
     * @return
     */
   PageInfo<Map<String, Object>> selectAllUser(Map<String, Object> map);


    /**
     * 删除游戏
     * @param id
     * @return
     */
   int deleteByPrimaryKey(String id);


    /**
     * 添加游戏
     * @param gameList
     * @return
     */
   int insert(GameList gameList);



}
