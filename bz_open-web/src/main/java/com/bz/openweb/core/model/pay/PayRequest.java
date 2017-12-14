package com.bz.openweb.core.model.pay;

import com.bz.framework.pojo.base.BasePojo;
/**
 *  作者:唐鹏
 *  描述:支付请求
 *  备注:
 *  创建时间:2017年11月28日上午10:33:18
 */
public class PayRequest extends BasePojo{

	private static final long serialVersionUID = -4172350304910131137L;
	
	private String payWay;//支付方式 10001:微信支付 10002:支付宝支付
	
	private String payMoney;//支付金额
	
	private Integer merchantId;//商户Id
	
	private Integer redPackageId;//红包Id
	
	private String  discountMoney;//红包抵扣金额
	
	private String payKey;//支付验证码

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getRedPackageId() {
		return redPackageId;
	}

	public void setRedPackageId(Integer redPackageId) {
		this.redPackageId = redPackageId;
	}

	public String getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(String discountMoney) {
		this.discountMoney = discountMoney;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}
}
