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
import com.hywl.cck.direct.entity.DirGiftInfo;
import com.hywl.cck.direct.mapper.DirGiftInfoMapper;
import com.hywl.cck.direct.service.DirectGiftInfoService;

@Service("directGiftInfoService")
public class DirectGiftInfoServiceImpl implements DirectGiftInfoService {

	@Resource
	private DirGiftInfoMapper dirGiftInfoMapper;
	
	/***
	 * 查询礼物信息
	 */
	@Override
	public PageInfo<Map<String, Object>> selectGiftInfoList(Map<String, Object> map) {
		PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))), Integer.valueOf(String.valueOf(map.get("pageSize"))));
        List<Map<String, Object>> list = this.dirGiftInfoMapper.selectGiftInfoList(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list == null ? new ArrayList<>() : list);
        return pageInfo;
	}

	/***
	 * 添加礼物信息
	 */
	@Override
	public int add(DirGiftInfo dirGiftInfo) {
		dirGiftInfo.setCreateTime(new Date());
		dirGiftInfo.setModifyTime(new Date());
		dirGiftInfo.setGiftInfoId(TablePrefixUtil.dir_gift_info + String.valueOf(IdWorkerAide.nextId()));
	    return this.dirGiftInfoMapper.insertSelective(dirGiftInfo);
	}

	/***
	 * 删除礼物信息
	 * @return 
	 */
	@Override
	public void delete(String giftInfoId) {
		this.dirGiftInfoMapper.deleteByPrimaryKey(giftInfoId);
	}

	/***
	 * 获取礼物信息
	 */
	@Override
	public DirGiftInfo get(String cuisineInfoId) {
		return this.dirGiftInfoMapper.selectByPrimaryKey(cuisineInfoId);
	}

	/***
	 * 修改礼物信息
	 */
	@Override
	public int update(DirGiftInfo record) {
		record.setModifyTime(new Date());
		return this.dirGiftInfoMapper.updateByPrimaryKey(record);
	}

}
