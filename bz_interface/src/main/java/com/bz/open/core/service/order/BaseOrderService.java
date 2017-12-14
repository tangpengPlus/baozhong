package com.bz.open.core.service.order;
import com.bz.framework.constant.order.OrderEnum;
import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
import com.bz.framework.error.exception.OrderException;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月1日下午2:08:00
 * 描述:订单基础服务
 * 备注:
 */
public interface BaseOrderService {
	
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日下午2:09:13
	 * 描述:判断当前订单是否成功
	 * 备注:
	 * @param orderNumber:订单编号
	 * @return
	 * @throws OrderException {@link OrderException} 订单服务异常封装
	 */
	public boolean isSuccessOrder(String orderNumber)throws OrderException;
	
	/**
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日下午2:20:50
	 * 描述:改变订单的状态
	 * 备注:
	 * @param orderNumber:订单编号
	 * @param orderEnum:订单状态枚举 {@link OrderEnum}
	 * @param signStr:每个订单唯一签名字符串
	 * @return
	 * @throws OrderException {@link OrderException }订单服务异常封装
	 */
	public void changeOrderState(String orderNumber,OrderStateEnum orderStateEnum,String  signStr)throws OrderException;
	
	
}
