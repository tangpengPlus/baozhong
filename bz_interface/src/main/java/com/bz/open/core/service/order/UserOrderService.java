package com.bz.open.core.service.order;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:查询用户订单信息
 * 创建时间:2017年11月3日下午6:48:00
 * 修改备注:
 */

import java.util.List;

import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
import com.bz.framework.error.exception.OrderException;
import com.bz.open.core.vo.response.order.UserOrderResponseVo;

public interface UserOrderService {

	 /**
	  * 
	  * 作者:彭云山
	  * 创建时间:2017年11月3日下午8:02:42
	  * 描述:查询用户的订单状态
	  * @param userId {@link userId} 用户ID
	  * @param orderStateEnum {@link orderStateEnum}订单状态枚举支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
	  * @return
	  * @throws OrderException
	  */
	public List<UserOrderResponseVo> selectUserOrderByOrderStatus(Integer userId,OrderStateEnum orderStateEnum)throws OrderException;
	
	/**
	* @作者 胡竞
	* @Title: selectUserOrderByOrderId 
	* @Description: TODO(通过订单ID查询用户的订单) 
	* @param @param orderId 订单ID
	* @param @return
	* @param @throws OrderException    设定文件 
	* @return UserOrderResponseVo    返回类型 
	* @throws
	 */
	public UserOrderResponseVo selectUserOrderByOrderId(Integer orderId)throws OrderException;
}
