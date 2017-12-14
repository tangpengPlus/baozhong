package com.bz.framework.pojo.base;

import com.bz.framework.constant.message.MessageEnum.MessageTypeEnum;
import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日上午11:31:51
 * 描述:消息基础类
 * 备注:所有消息序列话继承此类
 */
public abstract class BaseMessage extends BasePojo{

	private static final long serialVersionUID = -6098711170560690735L;
	
	private String tilte;//消息标题
	
	private String count;//消息内容
	
	private String createTime;//消息创建时间
	
	private MessageTypeEnum msgType;//发送消息类型
	
	private boolean isRecord;//是否记录到数据库中
	
	

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


	public MessageTypeEnum getMsgType() {
		return msgType;
	}

	public void setMsgType(MessageTypeEnum msgType) {
		this.msgType = msgType;
	}

	public boolean isRecord() {
		return isRecord;
	}

	public void setRecord(boolean isRecord) {
		this.isRecord = isRecord;
	}
	
	
	
	

}
