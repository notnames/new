package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 酒店信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-19 10:56:06
 */
@TableName("jiudianxinxi")
public class JiudianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiudianxinxiEntity() {
		
	}
	
	public JiudianxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 酒店编号
	 */
					
	private String jiudianbianhao;
	
	/**
	 * 酒店名称
	 */
					
	private String jiudianmingcheng;
	
	/**
	 * 城市
	 */
					
	private String chengshi;
	
	/**
	 * 酒店类别
	 */
					
	private String jiudianleibie;
	
	/**
	 * 酒店星级
	 */
					
	private String jiudianxingji;
	
	/**
	 * 房间类型
	 */
					
	private String fangjianleixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 价格（天）
	 */
					
	private Integer jiage;
	
	/**
	 * 友情链接
	 */
					
	private String youqinglianjie;
	
	/**
	 * 房间状态
	 */
					
	private String fangjianzhuangtai;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 酒店地址
	 */
					
	private String jiudiandizhi;
	
	/**
	 * 酒店介绍
	 */
					
	private String jiudianjieshao;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：酒店编号
	 */
	public void setJiudianbianhao(String jiudianbianhao) {
		this.jiudianbianhao = jiudianbianhao;
	}
	/**
	 * 获取：酒店编号
	 */
	public String getJiudianbianhao() {
		return jiudianbianhao;
	}
	/**
	 * 设置：酒店名称
	 */
	public void setJiudianmingcheng(String jiudianmingcheng) {
		this.jiudianmingcheng = jiudianmingcheng;
	}
	/**
	 * 获取：酒店名称
	 */
	public String getJiudianmingcheng() {
		return jiudianmingcheng;
	}
	/**
	 * 设置：城市
	 */
	public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
	}
	/**
	 * 获取：城市
	 */
	public String getChengshi() {
		return chengshi;
	}
	/**
	 * 设置：酒店类别
	 */
	public void setJiudianleibie(String jiudianleibie) {
		this.jiudianleibie = jiudianleibie;
	}
	/**
	 * 获取：酒店类别
	 */
	public String getJiudianleibie() {
		return jiudianleibie;
	}
	/**
	 * 设置：酒店星级
	 */
	public void setJiudianxingji(String jiudianxingji) {
		this.jiudianxingji = jiudianxingji;
	}
	/**
	 * 获取：酒店星级
	 */
	public String getJiudianxingji() {
		return jiudianxingji;
	}
	/**
	 * 设置：房间类型
	 */
	public void setFangjianleixing(String fangjianleixing) {
		this.fangjianleixing = fangjianleixing;
	}
	/**
	 * 获取：房间类型
	 */
	public String getFangjianleixing() {
		return fangjianleixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：价格（天）
	 */
	public void setJiage(Integer jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格（天）
	 */
	public Integer getJiage() {
		return jiage;
	}
	/**
	 * 设置：友情链接
	 */
	public void setYouqinglianjie(String youqinglianjie) {
		this.youqinglianjie = youqinglianjie;
	}
	/**
	 * 获取：友情链接
	 */
	public String getYouqinglianjie() {
		return youqinglianjie;
	}
	/**
	 * 设置：房间状态
	 */
	public void setFangjianzhuangtai(String fangjianzhuangtai) {
		this.fangjianzhuangtai = fangjianzhuangtai;
	}
	/**
	 * 获取：房间状态
	 */
	public String getFangjianzhuangtai() {
		return fangjianzhuangtai;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：酒店地址
	 */
	public void setJiudiandizhi(String jiudiandizhi) {
		this.jiudiandizhi = jiudiandizhi;
	}
	/**
	 * 获取：酒店地址
	 */
	public String getJiudiandizhi() {
		return jiudiandizhi;
	}
	/**
	 * 设置：酒店介绍
	 */
	public void setJiudianjieshao(String jiudianjieshao) {
		this.jiudianjieshao = jiudianjieshao;
	}
	/**
	 * 获取：酒店介绍
	 */
	public String getJiudianjieshao() {
		return jiudianjieshao;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
