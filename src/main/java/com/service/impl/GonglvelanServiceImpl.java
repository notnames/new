package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GonglvelanDao;
import com.entity.GonglvelanEntity;
import com.service.GonglvelanService;
import com.entity.vo.GonglvelanVO;
import com.entity.view.GonglvelanView;

@Service("gonglvelanService")
public class GonglvelanServiceImpl extends ServiceImpl<GonglvelanDao, GonglvelanEntity> implements GonglvelanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GonglvelanEntity> page = this.selectPage(
                new Query<GonglvelanEntity>(params).getPage(),
                new EntityWrapper<GonglvelanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GonglvelanEntity> wrapper) {
		  Page<GonglvelanView> page =new Query<GonglvelanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GonglvelanVO> selectListVO(Wrapper<GonglvelanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GonglvelanVO selectVO(Wrapper<GonglvelanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GonglvelanView> selectListView(Wrapper<GonglvelanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GonglvelanView selectView(Wrapper<GonglvelanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GonglvelanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GonglvelanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GonglvelanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
