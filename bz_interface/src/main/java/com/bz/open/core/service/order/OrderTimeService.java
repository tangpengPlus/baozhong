package com.bz.open.core.service.order;

import com.bz.framework.error.exception.OrderException;

/**
 * 
 *  作者:唐鹏
 *  描述:订单超时开放服务
 *  备注:
 *  创建时间:2017年11月27日下午1:57:04
 */
public interface OrderTimeService {

	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:订单超时处理
	 *  备注:
	 *  创建时间:2017年11月27日下午1:58:53
	 *  @param timeInterval:超时时间区间
	 *  @throws OrderException 订单异常类型封装
	 */
	public void orderTimeOutHandler(long timeInterval)throws OrderException;
}
