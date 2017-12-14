package com.bz.open.core.vo.request.notify;

import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:33:38
 * 描述:
 * 备注:
 */
public class PayNotifyRequest extends BasePojo{

	private static final long serialVersionUID = 1957566657485431037L;
	
	private String orderNumber;//支付订单号
	
	private OrderStateEnum orderStateEnum;
	
	private String payMessage;//支付回调消息
	
	private Integer payUserId;//支付用户Id
	
	private Integer payMerchantId;//支付商户Id
	
	private String payCode;//支付回调状态码
	
	private String orderSign;//订单签名

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderStateEnum getOrderStateEnum() {
		return orderStateEnum;
	}

	public void setOrderStateEnum(OrderStateEnum orderStateEnum) {
		this.orderStateEnum = orderStateEnum;
	}

	public String getPayMessage() {
		return payMessage;
	}

	public void setPayMessage(String payMessage) {
		this.payMessage = payMessage;
	}

	public Integer getPayUserId() {
		return payUserId;
	}

	public void setPayUserId(Integer payUserId) {
		this.payUserId = payUserId;
	}

	public Integer getPayMerchantId() {
		return payMerchantId;
	}

	public void setPayMerchantId(Integer payMerchantId) {
		this.payMerchantId = payMerchantId;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getOrderSign() {
		return orderSign;
	}

	public void setOrderSign(String orderSign) {
		this.orderSign = orderSign;
	}
	
	
}
