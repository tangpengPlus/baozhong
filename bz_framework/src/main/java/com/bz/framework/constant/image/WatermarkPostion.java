package com.bz.framework.constant.image;
import java.io.Serializable;

import com.bz.framework.constant.base.BaseEnum;
/** 
 * <p>水印位置枚举</p> 
 * 
 * 定义水印位置枚举。 
 * 
 * @author 唐鹏
 * @version 1.0.0 Date: 2016年11月15日 下午2:22:49
 */ 
public enum WatermarkPostion implements BaseEnum<Integer>,Serializable{
	/**
	 * 无水印
	 */
	NONE(-1, "无"), 
	/**
	 * 中间位置
	 */
	CENTER(0, "中间"),
	/**
	 * 左上位置
	 */
	LEFT_TOP(1, "左上"),
	/**
	 * 右上位置
	 */
	RIGHT_TOP(2, "右上"),
	/**
	 * 左下位置
	 */
	LEFT_BOTTOM(3, "左下"),
	/**
	 * 右下位置
	 */
	RIGHT_BOTTOM(4, "右下");
	private int key;
	private String title;
	private WatermarkPostion(int key,String title){
		this.key=key;
		this.title=title;
	}

	@Override
	public Integer getKey() {
		return key;
	}

	@Override
	public String getTitle() {
		return title;
	}
	public static WatermarkPostion valueOf(int key){
		for(WatermarkPostion p:WatermarkPostion.values()){
			if(p.getKey()==key){
				return p;
			}
		}
		return WatermarkPostion.NONE;
	}
	@Override
	public String toString() {
		return "[key=" + this.key + ",title=" + this.title +  "]";
	}
}
