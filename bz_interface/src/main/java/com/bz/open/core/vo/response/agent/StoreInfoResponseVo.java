package com.bz.open.core.vo.response.agent;

import java.math.BigDecimal;

import com.bz.framework.pojo.base.BasePojo;

public class StoreInfoResponseVo extends BasePojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4831500873406586897L;
	private String cilentName;//客户姓名
	private String storeName;//商家姓名
	private String time;//时间
	private String city;//城市
	private String agentName;//合伙人姓名
	private Integer size;//数量
	private BigDecimal money;//交易金额
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal bigDecimal) {
		this.money = bigDecimal;
	}
	public String getCilentName() {
		return cilentName;
	}
	public void setCilentName(String cilentName) {
		this.cilentName = cilentName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
