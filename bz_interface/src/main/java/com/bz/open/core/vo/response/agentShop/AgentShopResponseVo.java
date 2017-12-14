package com.bz.open.core.vo.response.agentShop;

import com.bz.framework.pojo.base.BasePojo;

public class AgentShopResponseVo extends BasePojo {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tell;//电话
	private String shopName;//店铺名
	private Integer size;//交易次数
	private String time;//时间
	private String city;//城市
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
