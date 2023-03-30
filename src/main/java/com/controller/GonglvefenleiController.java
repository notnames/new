package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GonglvefenleiEntity;
import com.entity.view.GonglvefenleiView;

import com.service.GonglvefenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 攻略分类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
@RestController
@RequestMapping("/gonglvefenlei")
public class GonglvefenleiController {
    @Autowired
    private GonglvefenleiService gonglvefenleiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonglvefenleiEntity gonglvefenlei,
		HttpServletRequest request){
        EntityWrapper<GonglvefenleiEntity> ew = new EntityWrapper<GonglvefenleiEntity>();

		PageUtils page = gonglvefenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonglvefenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GonglvefenleiEntity gonglvefenlei, 
		HttpServletRequest request){
        EntityWrapper<GonglvefenleiEntity> ew = new EntityWrapper<GonglvefenleiEntity>();

		PageUtils page = gonglvefenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonglvefenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonglvefenleiEntity gonglvefenlei){
       	EntityWrapper<GonglvefenleiEntity> ew = new EntityWrapper<GonglvefenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonglvefenlei, "gonglvefenlei")); 
        return R.ok().put("data", gonglvefenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonglvefenleiEntity gonglvefenlei){
        EntityWrapper< GonglvefenleiEntity> ew = new EntityWrapper< GonglvefenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonglvefenlei, "gonglvefenlei")); 
		GonglvefenleiView gonglvefenleiView =  gonglvefenleiService.selectView(ew);
		return R.ok("查询攻略分类成功").put("data", gonglvefenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonglvefenleiEntity gonglvefenlei = gonglvefenleiService.selectById(id);
        return R.ok().put("data", gonglvefenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonglvefenleiEntity gonglvefenlei = gonglvefenleiService.selectById(id);
        return R.ok().put("data", gonglvefenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GonglvefenleiEntity gonglvefenlei, HttpServletRequest request){
    	gonglvefenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonglvefenlei);
        gonglvefenleiService.insert(gonglvefenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GonglvefenleiEntity gonglvefenlei, HttpServletRequest request){
    	gonglvefenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonglvefenlei);
        gonglvefenleiService.insert(gonglvefenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GonglvefenleiEntity gonglvefenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonglvefenlei);
        gonglvefenleiService.updateById(gonglvefenlei);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gonglvefenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GonglvefenleiEntity> wrapper = new EntityWrapper<GonglvefenleiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = gonglvefenleiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
