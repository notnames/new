package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GonglvefenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GonglvefenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GonglvefenleiView;


/**
 * 攻略分类
 *
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
public interface GonglvefenleiService extends IService<GonglvefenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonglvefenleiVO> selectListVO(Wrapper<GonglvefenleiEntity> wrapper);
   	
   	GonglvefenleiVO selectVO(@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);
   	
   	List<GonglvefenleiView> selectListView(Wrapper<GonglvefenleiEntity> wrapper);
   	
   	GonglvefenleiView selectView(@Param("ew") Wrapper<GonglvefenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonglvefenleiEntity> wrapper);
   	

}

