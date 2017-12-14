package com.bz.open.core.vo.request.weixin;

import java.math.BigDecimal;

import com.bz.framework.constant.pay.WeiXinPaymentScenarioEnum;
import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月3日下午2:36:56
 * 描述:微信支付请求参数封装
 * 备注:
 */
public class WeixinPayRequet extends BasePojo{

	private static final long serialVersionUID = 1L;
	
	private String deviceInfo;//自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
	
	private String nonceStr;//随机字符串，长度要求在32位以内
	
	private String orderDescribe;//订单描述
	
	private String orderDetail;//订单详情
	
	private String attach;//附加参数
	
	private String orderNumber;//订单编号
	
	private BigDecimal payMoney;//支付金额
	
	private String requstIp;//请求Ip
	
	private WeiXinPaymentScenarioEnum weiXinPaymentScenarioEnum;//微信支付类型
	
	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getOrderDescribe() {
		return orderDescribe;
	}

	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}

	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

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

	public String getRequstIp() {
		return requstIp;
	}

	public void setRequstIp(String requstIp) {
		this.requstIp = requstIp;
	}

	/**
	 * @return the weiXinPaymentScenarioEnum
	 */
	public WeiXinPaymentScenarioEnum getWeiXinPaymentScenarioEnum() {
		return weiXinPaymentScenarioEnum;
	}

	/**
	 * @param weiXinPaymentScenarioEnum the weiXinPaymentScenarioEnum to set
	 */
	public void setWeiXinPaymentScenarioEnum(WeiXinPaymentScenarioEnum weiXinPaymentScenarioEnum) {
		this.weiXinPaymentScenarioEnum = weiXinPaymentScenarioEnum;
	}
	
}
