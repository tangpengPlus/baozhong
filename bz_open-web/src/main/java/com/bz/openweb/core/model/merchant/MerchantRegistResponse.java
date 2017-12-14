package com.bz.openweb.core.model.merchant;

import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 作者: 彭云山
 * 描述: 商家注册返回封装
 * 创建时间:2017年11月8日下午12:06:00
 * 修改备注:
 */
public class MerchantRegistResponse extends BasePojo{


	private static final long serialVersionUID = 8432963300927369250L;

	private String number;//商家的编号

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
