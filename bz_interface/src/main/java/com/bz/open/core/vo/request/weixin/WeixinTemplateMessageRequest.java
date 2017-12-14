package com.bz.open.core.vo.request.weixin;

import com.bz.framework.pojo.base.BaseMessage;

import com.bz.framework.constant.message.MessageEnum.WeixinTemplateMessageEnum;;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午2:50:48
 * 描述:微信群发消息封装
 * 备注:
 */
public class WeixinTemplateMessageRequest extends BaseMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5036668795162875660L;
	
	private WeixinTemplateMessageEnum  messageEnum;//消息模板现象
	
	private String openId;//接收用户的OpenId
	
	private String url;//消息链接
	
	private WeixinTemplageMessageValue value;//参数和值得封装

	public WeixinTemplateMessageEnum getMessageEnum() {
		return messageEnum;
	}

	public void setMessageEnum(WeixinTemplateMessageEnum messageEnum) {
		this.messageEnum = messageEnum;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WeixinTemplageMessageValue getValue() {
		return value;
	}

	public void setValue(WeixinTemplageMessageValue value) {
		this.value = value;
	}

	
	
	
	

}
