package com.dao;

import com.entity.GonglvefenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GonglvefenleiVO;
import com.entity.view.GonglvefenleiView;


/**
 * 攻略分类
 * 
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
public interface GonglvefenleiDao extends BaseMapper<GonglvefenleiEntity> {
	
	List<GonglvefenleiVO> selectListVO(@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);
	
	GonglvefenleiVO selectVO(@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);
	
	List<GonglvefenleiView> selectListView(@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);

	List<GonglvefenleiView> selectListView(Pagination page,@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);
	
	GonglvefenleiView selectView(@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);
	

}
