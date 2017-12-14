package com.bz.open.core.vo.response.order;

import java.math.BigDecimal;

import com.bz.framework.pojo.base.BasePojo;
/**
 *  作者:唐鹏
 *  描述:
 *  备注:
 *  创建时间:2017年11月15日下午4:17:35
 */
public class ScanOrderResponseVo extends BasePojo{

	private static final long serialVersionUID = 8900848820566069729L;
	
	private String orderNo;//订单编号
	
	private String orderSign;//订单签名
	
	private BigDecimal payMoney;//支付金额

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderSign() {
		return orderSign;
	}

	public void setOrderSign(String orderSign) {
		this.orderSign = orderSign;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	
	
	

}
