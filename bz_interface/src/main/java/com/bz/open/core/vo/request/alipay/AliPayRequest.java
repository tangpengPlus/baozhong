package com.bz.open.core.vo.request.alipay;

import java.math.BigDecimal;

import com.bz.framework.constant.pay.AliPayPaymentScenarioEnum;
import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日上午11:15:31
 * 描述:支付宝支付请求参数封装
 * 备注:
 */
public class AliPayRequest extends BasePojo{


	private static final long serialVersionUID = -1787455001616783308L;
	
	private String orderNumber;//订单编号
	
	private BigDecimal payMoney;//支付金额
	
	private AliPayPaymentScenarioEnum aliPayPaymentScenarioEnum;//产品代码封装
	
	private String orderTitle;//订单标题

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public AliPayPaymentScenarioEnum getAliPayPaymentScenarioEnum() {
		return aliPayPaymentScenarioEnum;
	}

	public void setAliPayPaymentScenarioEnum(AliPayPaymentScenarioEnum aliPayPaymentScenarioEnum) {
		this.aliPayPaymentScenarioEnum = aliPayPaymentScenarioEnum;
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}
	
	
	
	
	

}
