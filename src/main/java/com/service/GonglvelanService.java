package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GonglvelanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GonglvelanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GonglvelanView;


/**
 * 攻略栏
 *
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
public interface GonglvelanService extends IService<GonglvelanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonglvelanVO> selectListVO(Wrapper<GonglvelanEntity> wrapper);
   	
   	GonglvelanVO selectVO(@Param("ew") Wrapper<GonglvelanEntity> wrapper);
   	
   	List<GonglvelanView> selectListView(Wrapper<GonglvelanEntity> wrapper);
   	
   	GonglvelanView selectView(@Param("ew") Wrapper<GonglvelanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonglvelanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GonglvelanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GonglvelanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GonglvelanEntity> wrapper);



}

