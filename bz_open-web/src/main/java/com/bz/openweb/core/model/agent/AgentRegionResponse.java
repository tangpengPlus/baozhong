package com.bz.openweb.core.model.agent;

import com.bz.framework.pojo.base.BasePojo;

/**
 * 
 * @author 陈青山
 * @miaoshu 合伙人注册返回封装
 *
 */
public class AgentRegionResponse extends BasePojo{
	private static final long serialVersionUID = -6599698632343630620L;
	private String number;//合伙人id

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
