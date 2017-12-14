package com.bz.open.core.vo.request.sms;

import java.util.List;

import com.bz.framework.pojo.base.BaseMessage;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午4:51:30
 * 描述:短信封装
 * 备注:
 */
public class SmsMessageRequest extends BaseMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5985640479698300769L;
	
	private String telPhone;//电话号码
	
	private boolean isSendOne;//单发or群发
	
	private List<String> telPhones;//电话号码集合
	
	private String code;//验证码生成
	
	private Integer codeEndTime;//验证码有效期

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public boolean isSendOne() {
		return isSendOne;
	}

	public void setSendOne(boolean isSendOne) {
		this.isSendOne = isSendOne;
	}

	public List<String> getTelPhones() {
		return telPhones;
	}

	public void setTelPhones(List<String> telPhones) {
		this.telPhones = telPhones;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCodeEndTime() {
		return codeEndTime;
	}

	public void setCodeEndTime(Integer codeEndTime) {
		this.codeEndTime = codeEndTime;
	}

	
	

}
