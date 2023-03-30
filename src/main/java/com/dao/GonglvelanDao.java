package com.dao;

import com.entity.GonglvelanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GonglvelanVO;
import com.entity.view.GonglvelanView;


/**
 * 攻略栏
 * 
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
public interface GonglvelanDao extends BaseMapper<GonglvelanEntity> {
	
	List<GonglvelanVO> selectListVO(@Param("ew") Wrapper<GonglvelanEntity> wrapper);
	
	GonglvelanVO selectVO(@Param("ew") Wrapper<GonglvelanEntity> wrapper);
	
	List<GonglvelanView> selectListView(@Param("ew") Wrapper<GonglvelanEntity> wrapper);

	List<GonglvelanView> selectListView(Pagination page,@Param("ew") Wrapper<GonglvelanEntity> wrapper);
	
	GonglvelanView selectView(@Param("ew") Wrapper<GonglvelanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GonglvelanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GonglvelanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GonglvelanEntity> wrapper);



}
