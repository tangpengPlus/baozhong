package com.bz.framework.constant.upload;

import com.bz.framework.constant.base.BaseEnum;

/** 
 * <p>文件、图片规格</p> 
 * 
 * 定义文件、图片规格枚举。 
 * 
 * @author 唐鹏
 * @version 1.0.0 Date: 2016年11月15日 下午2:21:42
 */ 
public enum UploadFileFormat implements BaseEnum<Integer> {
	/**
	 * 默认1比1尺寸规格
	 */
	DEFAULT(0, "default", "1*1"),//默认原图
	
	/**
	 * 用户头像（大：80*80）
	 */
	USER_MAX(1,"user-max","80*80"),//用户头像（大）
	/**
	 * 用户头像（中：50*50）
	 */
	USER_MID(2,"user-mid","50*50"),//用户头像（中）
	/**
	 * 用户头像（小：30*30）
	 */
	USER_MIN(3,"user-min","30*30"),//用户头像（小）
	/**
	 * 商家店铺LOGO（大：419*205）
	 */
	SHOP_LOGO_A_MAX(1,"shop-logo-a-max","419*205"),//商家LOGO（大）
	/**
	 * 商家店铺LOGO（中：232*114）
	 */
	SHOP_LOGO_A_MID(2,"shop-logo-a-mid","232*114"),//商家LOGO（中）
	/**
	 * 商家店铺LOGO（小：168*82）
	 */
	SHOP_LOGO_A_MIN(3,"shop-logo-a-min","168*82"),//商家LOGO（小）
	/**
	 * 店铺实拍
	 */
	SHOP_VIEW(1,"shop-view","1*1"),//商品缩略图，750*640
	
	/**
	 * 商品主图规格（大:252*123）
	 */
	GOODS_MAIN_A_MAX(1, "goods-main-a-max", "252*123"),//商品规格（大）
	/**
	 * 商品主图规格（中:168*82）
	 */
	GOODS_MAIN_A_MID(2, "goods-main-a-mid", "168*82"),//商品规格（中）
	/**
	 * 商品主图规格（小:90*44）
	 */
	GOODS_MAIN_A_MIN(3, "goods-main-a-min", "90*44"),//商品规格（小）
	/**
	 * 商品列表规格(252*123)
	 */
	GOODS_MAIN_A_LIST(4, "goods-main-a-list", "252*123"),//商品列表规格
	/**
	 * 商品实拍
	 */
	GOODS_VIEW(5,"goods-view","1*1"),//商品缩略图,规格未确定
	/**
	 * 商品评价图
	 */
	GOODS_COMMENT_VIEW(1,"goods-comment-view","1*1"),//评论缩略图，规格未确定
	
	/**
	 * 菜品详情图规格
	 */
	DISH_VIEW(1,"dish-view","1*1"),//菜品详情图片，750*600
	/**
	 * 菜品列表图规格
	 */
	DISH_LIST(2,"dish-list","150*120");//菜品列表图片，规格未确定
	
	//key，id
	private int key;
	//名称
	private String title;
	//尺寸规格
	private String format;
	private UploadFileFormat(int key, String title, String format) {
		this.key = key;
		this.title = title;
		this.format = format;
	}

	public Integer getKey() {
		return this.key;
	}

	public String getTitle() {
		return this.title;
	}

	public String getFormat() {
		return format;
	}

	/**
	 * 根据Key生成对应枚举对象 如果没有查找到返回null
	 * 
	 * @param key
	 *            key值
	 * @return 生成的枚举对象
	 */
	public static UploadFileFormat valueOf(int key) {
		for (UploadFileFormat type : UploadFileFormat.values()) {
			if (type.getKey() == key) {
				return type;
			}
		}
		return null;
	}

	/**
	 * 根据具体规格生成对应枚举对象 如果没有查找到返回null
	 * 
	 * @param format
	 *            具体规格尺寸。60*60
	 * @return 生成的枚举对象
	 */
	public static UploadFileFormat valueOfFormat(String format) {
		for (UploadFileFormat type : UploadFileFormat.values()) {
			if (type.getFormat().equals(format)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "[key=" + this.key + ",title=" + this.title + "]";
	}
}
