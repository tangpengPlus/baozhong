package com.bz.openweb.core.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.order.UserOrderService;
import com.bz.open.core.vo.response.order.UserOrderResponseVo;

/**
* @ClassName: UserOrderMessageService 
* @Description: TODO(用户订单消息服务) 
* @author 胡竞
* @date 2017年11月24日 下午5:50:54 
*
 */
@Service
public class UserOrderMessageService {

	private final Logger logger=LoggerFactory.getLogger(UserOrderMessageService.class);
	
	@Reference(version="1.0.0")
	private MerchantBaseService merchantBaseService;
	
	@Reference(version="1.0.0")
	private UserOrderService userOrderService;
	
	/**
	* @作者 胡竞
	* @Title: getUserOrder 
	* @Description: TODO(查询用户的所有订单) 
	* @param @param userId
	* @param @return    设定文件 
	* @return BaseResult<List<UserOrderResponseVo>>    返回类型 
	* @throws
	 */
	public BaseResult<List<UserOrderResponseVo>> getUserOrder(Integer userId){
		
		logger.info("查询的【userId:"+userId+"】");
		BaseResult<List<UserOrderResponseVo>> baseResult=BaseResult.newInstance();
		if(IntegerUtil.isEmpty(userId)) {
			logger.error("需查询的【userId:"+userId+"】为空");
			baseResult.changeStatus(ResultValueEnum.USER_ISNULL_ERROR);
			return baseResult;
		}
		try {
			baseResult.setData(userOrderService.selectUserOrderByOrderStatus(userId, null));
		} catch (Exception e) {
			logger.error("查询订单有误");
			baseResult.changeStatus(ResultValueEnum.ORDER_SEARCH_NOT_EXIST);
		}
		return baseResult;
	}
	
	/**
	* @作者 胡竞
	* @Title: getDetailsOrder 
	* @Description: TODO(查询用户指定ID订单) 
	* @param @param orderId
	* @param @return    设定文件 
	* @return BaseResult<UserOrderResponseVo>    返回类型 
	* @throws
	 */
	public BaseResult<UserOrderResponseVo> getDetailsOrder(Integer orderId){
		logger.info("传入的订单ID【orderId:"+orderId+"】");
		BaseResult<UserOrderResponseVo> baseResult=BaseResult.newInstance();
		if(IntegerUtil.isEmpty(orderId)) {
			logger.error("传入的订单ID【orderId:"+orderId+"】为空");
			baseResult.changeStatus(ResultValueEnum.ORDER_IDISNULL_ERROR);
			return baseResult;
		}
		try {
			baseResult.setData(userOrderService.selectUserOrderByOrderId(orderId));
		} catch (Exception e) {
			logger.error("当前用户的订单查询失败");
			baseResult.changeStatus(ResultValueEnum.ORDER_SEARCH_NOT_EXIST);
		}
		
		return baseResult;
	}
	
	
}
