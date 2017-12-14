package com.bz.open.core.vo.request.weixin;
import java.io.InputStream;
import java.util.List;

import com.bz.framework.constant.message.MessageEnum.MessageTypeEnum;
import com.bz.framework.pojo.base.BasePojo;

import me.chanjar.weixin.mp.bean.WxMpMassNews;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日上午11:36:16
 * 描述:微信群发消息封装
 * 备注:
 */
public class WeixinMassMessageRequest extends BasePojo{
	

	private static final long serialVersionUID = 4283113860567955237L;

	private boolean sendToOne;//是否发送给单个用户
	
	private String weixinUserOpenId;//微信用户openId针对单个用户

	private String fileIds;//本地系统中文件数据Id
	
	private String fileType;//文件类型
	
    private String tilte;//消息标题
	
	private String count;//消息内容
	
	private String createTime;//消息创建时间
	
	private boolean isRecord;//是否记录到数据库中
	
	private List<String> weixinUserOpenIds;//微信用户openId集合针对多个用户
	
	private MessageTypeEnum msgType;//发送消息类型
	
	private WxMpMassNews news;//发送图文消息内容
	

	public WxMpMassNews getNews() {
		return news;
	}

	public void setNews(WxMpMassNews news) {
		this.news = news;
	}

	public boolean isSendToOne() {
		return sendToOne;
	}

	public void setSendToOne(boolean sendToOne) {
		this.sendToOne = sendToOne;
	}

	public String getWeixinUserOpenId() {
		return weixinUserOpenId;
	}

	public void setWeixinUserOpenId(String weixinUserOpenId) {
		this.weixinUserOpenId = weixinUserOpenId;
	}

	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public boolean isRecord() {
		return isRecord;
	}

	public void setRecord(boolean isRecord) {
		this.isRecord = isRecord;
	}

	public List<String> getWeixinUserOpenIds() {
		return weixinUserOpenIds;
	}

	public void setWeixinUserOpenIds(List<String> weixinUserOpenIds) {
		this.weixinUserOpenIds = weixinUserOpenIds;
	}

	public MessageTypeEnum getMsgType() {
		return msgType;
	}

	public void setMsgType(MessageTypeEnum msgType) {
		this.msgType = msgType;
	}

}
