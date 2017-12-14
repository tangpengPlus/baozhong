package com.bz.open.core.vo.request.order;

import java.math.BigDecimal;

import com.bz.open.core.vo.order.BaseOrderVo;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月27日上午10:53:31
 * 描述:扫码支付订单扩展
 * 备注:
 */
public class ScanCodeOrderRequestVo extends BaseOrderVo{

	private static final long serialVersionUID = 7368490534351452110L;
	
	
	private boolean useCashCoupon;//是否使用代金券
	    
	private Integer cashCoupon;//用户代金券数据Id
	
	private BigDecimal cashCouponMoney;//代金券金额

	private String qrCodeLink;//扫码的二维码地址
	
	private String orderNumber;//订单编号封装
	
	public boolean isUseCashCoupon() {
		return useCashCoupon;
	}
	public void setUseCashCoupon(boolean useCashCoupon) {
		this.useCashCoupon = useCashCoupon;
	}
	public BigDecimal getCashCouponMoney() {
		return cashCouponMoney;
	}
	public void setCashCouponMoney(BigDecimal cashCouponMoney) {
		this.cashCouponMoney = cashCouponMoney;
	}
	public String getQrCodeLink() {
		return qrCodeLink;
	}
	public void setQrCodeLink(String qrCodeLink) {
		this.qrCodeLink = qrCodeLink;
	}
	public Integer getCashCoupon() {
		return cashCoupon;
	}
	public void setCashCoupon(Integer cashCoupon) {
		this.cashCoupon = cashCoupon;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
}
