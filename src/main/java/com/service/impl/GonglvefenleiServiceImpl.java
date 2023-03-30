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


import com.dao.GonglvefenleiDao;
import com.entity.GonglvefenleiEntity;
import com.service.GonglvefenleiService;
import com.entity.vo.GonglvefenleiVO;
import com.entity.view.GonglvefenleiView;

@Service("gonglvefenleiService")
public class GonglvefenleiServiceImpl extends ServiceImpl<GonglvefenleiDao, GonglvefenleiEntity> implements GonglvefenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GonglvefenleiEntity> page = this.selectPage(
                new Query<GonglvefenleiEntity>(params).getPage(),
                new EntityWrapper<GonglvefenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GonglvefenleiEntity> wrapper) {
		  Page<GonglvefenleiView> page =new Query<GonglvefenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GonglvefenleiVO> selectListVO(Wrapper<GonglvefenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GonglvefenleiVO selectVO(Wrapper<GonglvefenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GonglvefenleiView> selectListView(Wrapper<GonglvefenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GonglvefenleiView selectView(Wrapper<GonglvefenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
