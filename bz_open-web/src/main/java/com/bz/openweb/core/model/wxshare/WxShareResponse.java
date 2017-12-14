package com.bz.openweb.core.model.wxshare;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
/**
 * 
 * 作者: 彭云山
 * 描述: 微信分享返回封装
 * 创建时间:2017年11月8日上午11:35:47
 * 修改备注:
 */
public class WxShareResponse extends WxJsapiSignature{

	private static final long serialVersionUID = 2500201072863194452L;
	
	
	private String title;//分享标题
	
	private String link;//分享链接
	
	private String imgUrl;//分享图片
	
	private String desc;//分享描述

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
