package com.entity.view;

import com.entity.GonglvelanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 攻略栏
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
@TableName("gonglvelan")
public class GonglvelanView  extends GonglvelanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GonglvelanView(){
	}
 
 	public GonglvelanView(GonglvelanEntity gonglvelanEntity){
 	try {
			BeanUtils.copyProperties(this, gonglvelanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
