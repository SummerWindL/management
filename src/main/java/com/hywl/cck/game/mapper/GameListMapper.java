package com.hywl.cck.game.mapper;

import com.hywl.cck.game.entity.GameList;

import java.util.List;
import java.util.Map;

public interface GameListMapper {


    int deleteByPrimaryKey(String gameId);

    int insert(GameList record);

    int insertSelective(GameList record);

    GameList selectByPrimaryKey(String gameId);

    int updateByPrimaryKeySelective(GameList record);

    int updateByPrimaryKey(GameList record);


    /**
     * 分页显示游戏信息
     * @param type
     * @return
     */
    List<Map<String, Object>> getGameInfoList(int type);


    /**
     * 后台游戏列表显示
     * @param map
     * @return
     */
    List<Map<String, Object>> selectAllUser(Map<String, Object> map);




}