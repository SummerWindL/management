package com.hywl.cck.direct.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywl.cck.base.unit.db.IdWorkerAide;
import com.hywl.cck.base.unit.db.TablePrefixUtil;
import com.hywl.cck.direct.entity.DirGoldRmb;
import com.hywl.cck.direct.mapper.DirGoldRmbMapper;
import com.hywl.cck.direct.service.DirGoldRmbService;

@Service("dirGoldRmbService")
public class DirGoldRmbServiceImpl implements DirGoldRmbService {
	
	@Resource
	private DirGoldRmbMapper dirGoldRmbMapper;
	
	
	/***
	 * 查询分页
	 */
	@Override
	public PageInfo<Map<String, Object>> selectGoldRmbList(Map<String, Object> map) {
		PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
        List<Map<String, Object>> list = this.dirGoldRmbMapper.selectGoldRmbList(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list == null ? new ArrayList<>() : list);
        return pageInfo;
	}

	/***
	 * 增加
	 */
	@Override
	public int add(DirGoldRmb dirGoldRmb) {
		dirGoldRmb.setCreateTime(new Date());
		dirGoldRmb.setModifyTime(new Date());
		dirGoldRmb.setGiftGoldId(TablePrefixUtil.dir_gold_rmb + String.valueOf(IdWorkerAide.nextId()));
	    return this.dirGoldRmbMapper.insertSelective(dirGoldRmb);
	}

	/***
	 * 删除
	 */
	@Override
	public void delete(String giftGoldId) {
		this.dirGoldRmbMapper.deleteByPrimaryKey(giftGoldId);
	}

	/***
	 * 修改
	 */
	@Override
	public int update(DirGoldRmb dirGoldRmb) {
		dirGoldRmb.setModifyTime(new Date());
		return this.dirGoldRmbMapper.updateByPrimaryKeySelective(dirGoldRmb);
	}

	/***
	 * 获取信息
	 */
	@Override
	public DirGoldRmb get(String giftGoldId) {
		return this.dirGoldRmbMapper.selectByPrimaryKey(giftGoldId);
	}
	
}
