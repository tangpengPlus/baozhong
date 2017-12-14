package com.bz.openweb.config.wechat;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述: 构造微信分享参数
 * 创建时间:2017年11月8日上午11:42:18
 * 修改备注:
 */
@ConfigurationProperties(prefix = "wechat.share")
public class WechatShareProperties {

	private String title;
	
	private String link;
	
	private String imgUrl;
	
	private String desc;

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
