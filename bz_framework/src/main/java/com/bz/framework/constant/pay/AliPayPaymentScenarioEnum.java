package com.bz.framework.constant.pay;

import com.bz.framework.constant.base.BaseEnum;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午1:36:03
 * 描述:支付宝支付场景封装
 * 备注:
 */
public enum AliPayPaymentScenarioEnum  implements BaseEnum<String>{
	QUICK_MSECURITY_PAY("APP支付","QUICK_MSECURITY_PAY"),
	FAST_INSTANT_TRADE_PAY("PC支付","FAST_INSTANT_TRADE_PAY"),
	QUICK_WAP_PAY("移动H5支付","QUICK_WAP_PAY");

	private String key;
	private String message;
	
	private AliPayPaymentScenarioEnum(String key,String message) {
		this.key = key;
		this.message = message;
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.message;
	}

	public String toString() {
		return "[key="+key+",title="+message+"]";
	}
}
