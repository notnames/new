package com.dao;

import com.entity.JiudianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiudianxinxiVO;
import com.entity.view.JiudianxinxiView;


/**
 * 酒店信息
 * 
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
public interface JiudianxinxiDao extends BaseMapper<JiudianxinxiEntity> {
	
	List<JiudianxinxiVO> selectListVO(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
	
	JiudianxinxiVO selectVO(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
	
	List<JiudianxinxiView> selectListView(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);

	List<JiudianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
	
	JiudianxinxiView selectView(@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);


    List<Map<String, Object>> jiudianleibiejiudianleibieTypeStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiudianxinxiEntity> wrapper);

}
