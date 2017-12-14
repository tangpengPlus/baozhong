package com.bz.open.core.vo.order;

import java.math.BigDecimal;

import com.bz.framework.pojo.base.BasePojo;
import com.bz.framework.constant.order.OrderEnum.*;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月27日上午10:35:04
 * 描述:订单请求封装
 * 备注:
 */
public abstract class  BaseOrderVo extends BasePojo{

	private static final long serialVersionUID = 5305529233891674481L;

	private String requestIp;//请求ip
    
    private Integer userId;//支付用户ID
    
    private Integer merchantId;//商户id
    
    private String requestTimeStr;//请求时间戳
    
    private PayWay payWay;//支付方式 1：微信支付；2：支付宝支付；3：混合支付；
    
    private BigDecimal payMoney;//支付金额
    
    private BigDecimal totalMoney;//订单总金额
    
	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getRequestTimeStr() {
		return requestTimeStr;
	}

	public void setRequestTimeStr(String requestTimeStr) {
		this.requestTimeStr = requestTimeStr;
	}

	public PayWay getPayWay() {
		return payWay;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public void setPayWay(PayWay payWay) {
		this.payWay = payWay;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
    

	
    
    
    
    
    
    
}
