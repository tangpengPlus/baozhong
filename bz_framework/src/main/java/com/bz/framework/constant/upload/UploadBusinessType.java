package com.bz.framework.constant.upload;

import java.io.File;

import com.bz.framework.constant.base.BaseEnum;
import com.bz.framework.util.date.DateUtil;
import com.bz.framework.util.validate.TwoItem;
/** 
 * <p>上传文件业务类型</p> 
 * 
 * 定义上传文件业务类型枚举。 
 * 
 * @author 唐鹏
 * @version 1.0.0 Date: 2016年11月15日 下午2:18:29
 */ 
public enum UploadBusinessType implements BaseEnum<Integer>{
	/**
	 * 通用图片类型
	 */
	GENERAL_IMG(
			1, "通用图", File.separator + "res" 
					+ File.separator + "general" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "MM")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT}),
	/**
	 * 文档类形
	 */
	DOCUMENT(
			2, "文档类别", File.separator + "res" + File.separator + "doc" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "MM")+File.separator,
			new String[]{".doc",".xls",".docx",".xlsx",".wps",".et",".txt"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT}),
	/**
	 * 用户头像
	 */
	USER_HEAD(
			3, "用户头像", File.separator + "res" 
					+ File.separator + "user" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "MM")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT,UploadFileFormat.USER_MAX,UploadFileFormat.USER_MID,UploadFileFormat.USER_MIN}),
	/**
	 * 商品主图 (长方形)
	 */
	GOODS_MAIN_A(
			4, "商品主图", File.separator + "res" + File.separator + "goods" + File.separator + "a" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT,UploadFileFormat.GOODS_MAIN_A_MAX,UploadFileFormat.GOODS_MAIN_A_MID,UploadFileFormat.GOODS_MAIN_A_MIN,UploadFileFormat.GOODS_MAIN_A_LIST}),
	/**
	 * 商品主图(正方形)
	 */
	GOODS_MAIN_B(
			4, "商品主图", File.separator + "res" + File.separator + "goods" + File.separator + "b" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT}),
	/**
	 * 商品实拍图
	 */
	GOODS_VIEW(
			5, "商品实拍", File.separator + "res" +File.separator + "goods" + File.separator + "default" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT,UploadFileFormat.GOODS_VIEW}),
	/**
	 * 商品评价
	 */
	GOODS_COMMENT(
			6, "商品评价", File.separator + "res" +File.separator + "goods" + File.separator + "comment" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT,UploadFileFormat.GOODS_COMMENT_VIEW}),
	/**
	 * 商家/店铺 LOGO (长方形)
	 * A:长方形，B:正方形
	 */
	SHOP_LOGO_A(
			7, "商家/店铺LOGO", File.separator + "res" + File.separator + "shop" + File.separator + "a" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT,UploadFileFormat.SHOP_LOGO_A_MAX,UploadFileFormat.SHOP_LOGO_A_MID,UploadFileFormat.SHOP_LOGO_A_MIN}),
	/**
	 * 商家/店铺 LOGO (正方形)
	 * A:长方形，B:正方形
	 */
	SHOP_LOGO_B(
			7, "商家/店铺LOGO", File.separator + "res" + File.separator + "shop" + File.separator + "b" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT}),
	/**
	 * 店铺实拍
	 */
	SHOP_VIEW(
			8, "店铺实拍", File.separator + "res" + File.separator + "shop" + File.separator + "default" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "W")+File.separator,
			new String[]{".bmp",".png",".gif",".jpeg",".jpg"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT,UploadFileFormat.SHOP_VIEW}),
	/**
	 * APP客户端
	 */
	APP_CLIENT(
			9, "APP客户端软件", File.separator + "res" + File.separator + "appsoft" + File.separator
			+ DateUtil.formatDate("yyyy" + File.separator + "MM")+File.separator,
			new String[]{".apk",".ipa",".zip",".rar"},
			new UploadFileFormat[]{UploadFileFormat.DEFAULT}),
			;
	
	private Integer key;
	private String title;
	//文件浏览路径即相对路径
	private String viewPath;
	//允许的文件类型
	private String[] allowFileType;
	//文件的尺寸规格
	private UploadFileFormat[] fileFormat={};
	
	private UploadBusinessType(Integer key, String title, String saveFolder,String[] allowFileType,UploadFileFormat[] fileFormat) {
		this.key = key;
		this.title = title;
		this.viewPath = saveFolder;
		this.allowFileType=allowFileType;
		this.fileFormat=fileFormat;
	}
	public Integer getKey() {
		return key;
	}

	public String getTitle() {
		return title;
	}
	
	public String[] getAllowFileType() {
		return allowFileType;
	}
	public UploadFileFormat[] getFileFormat() {
		return fileFormat;
	}
	/**
	 * 获取用户头像图片保存文件夹
	 * 
	 * @param realPath
	 *            绝对路径
	 * @return 包含两个元素的字符串数组，第一个元素为完整的绝对路径用于实际保存文件，第二个元素为相对路径，用于页面显示
	 */
	public TwoItem<String, String> getSaveFolder(String realPath) {
		String fullFolder = realPath + viewPath;
		File file = new File(fullFolder);
		if (!file.exists()) {
			file.mkdirs();
		}
		return new TwoItem<String, String>(fullFolder, viewPath);
	}

	public static UploadBusinessType valueOfKey(String key) {
		for (UploadBusinessType type : UploadBusinessType.values()) {
			if (type.getKey().equals(key)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "[key=" + this.key + ",title=" + this.title + ",saveFolder="
				+ viewPath + "]";
	}
}
