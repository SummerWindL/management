package com.hywl.cck.game.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywl.cck.game.entity.GameList;
import com.hywl.cck.game.mapper.GameListMapper;
import com.hywl.cck.game.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: xiao
 * \* Date: 2017/11/25
 * \* Time: 16:48
 * \
 */
@Service
public class GameListServiceImpl implements GameListService {

    @Autowired
    private GameListMapper gameListMapper;


    /**
     * 获取 游戏信息列表
     * @return
     */
    @Override
    public List<Map<String, Object>> getGameInfoList(int type) {

        return gameListMapper.getGameInfoList(type);
    }




    /**
     * 根据ID获取游戏信息
     * @param gameID
     * @return
     */
    @Override
    public GameList getGameInfo(String gameID) {

        return  gameListMapper.selectByPrimaryKey(gameID);
    }

    /**
     * 后台的游戏列表
     * @param map
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> selectAllUser(Map<String, Object> map) {

            PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
            List<Map<String, Object>> list = gameListMapper.selectAllUser(map);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>((list == null) ? new ArrayList<>() : list);
            return pageInfo;
    }


    /**
     * 删除游戏
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {

        return gameListMapper.deleteByPrimaryKey(id);
    }


    /**
     * 添加游戏
     * @param gameList
     * @return
     */
    @Override
    public int insert(GameList gameList) { return gameListMapper.insert(gameList);}


}
