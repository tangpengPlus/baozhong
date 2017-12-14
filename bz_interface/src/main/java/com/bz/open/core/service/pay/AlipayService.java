package com.bz.open.core.service.pay;

import com.bz.framework.error.exception.PayException;
import com.bz.open.core.vo.request.alipay.AliPayRequest;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日上午10:49:08
 * 描述:Alipay服务实现
 * 备注:
 */
public interface AlipayService {

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日上午11:23:42
	 * 描述:支付宝支付开放服务
	 * 备注:
	 * @param aliPayRequest:支付宝支付请求参数 {@link AliPayRequest}
	 * @return
	 * @throws PayException {@link PayException}支付异常信息封装
	 */
	public String AlipayMobilePhoneOrder(AliPayRequest aliPayRequest)throws PayException;
}
