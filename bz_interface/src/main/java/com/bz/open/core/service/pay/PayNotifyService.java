package com.bz.open.core.service.pay;

import com.bz.framework.error.exception.PayException;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:28:55
 * 描述:
 * 备注:
 */
public interface PayNotifyService {

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日下午3:36:42
	 * 描述:支付回调处理
	 * 备注:
	 * @param payNotifyRequest {@link PayNotifyRequest} 支付回调参数封装
	 * @throws PayException {@link PayException}支付异常信息封装
	 */
	public void payNotify(PayNotifyRequest payNotifyRequest)throws PayException;
}
