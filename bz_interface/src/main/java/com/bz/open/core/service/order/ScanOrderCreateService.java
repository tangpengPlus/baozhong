package com.bz.open.core.service.order;

import com.bz.framework.error.exception.OrderException;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
import com.bz.open.core.vo.response.order.ScanOrderResponseVo;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月27日上午10:32:12
 * 描述: 系统订单开放服务
 * 备注:
 */
public interface ScanOrderCreateService {

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月27日上午10:50:05
	 * 描述:订单创建
	 * 备注: 订单的创建包含许多过程封装
	 * @param <T>
	 * @param orderVo 订单创建请求参数封装 {@link ScanCodeOrderRequestVo}
	 * @return
	 * @throws OrderException 订单异常类型封装{@link OrderException}
	 */
	public  ScanOrderResponseVo createOrder(ScanCodeOrderRequestVo codeOrderVo)throws OrderException;

}
