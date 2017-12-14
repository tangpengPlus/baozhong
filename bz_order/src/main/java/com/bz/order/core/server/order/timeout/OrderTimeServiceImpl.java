package com.bz.order.core.server.order.timeout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.order.OrderBaseMapper;
import com.bz.framework.constant.exception.BzExceptionEnum.OrderExceptionEnum;
import com.bz.framework.error.exception.OrderException;
import com.bz.open.core.service.order.OrderTimeService;
/**
 * 
 *  作者:唐鹏
 *  描述:订单超时服务处理
 *  备注:
 *  创建时间:2017年11月27日下午2:01:10
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.order.OrderTimeService.class)
@Transactional
public class OrderTimeServiceImpl implements OrderTimeService{

	private final Logger logger=LoggerFactory.getLogger(OrderTimeServiceImpl.class);
	
	@Autowired
	private OrderBaseMapper orderBaseMapper;
	
	
	@Override
	public void orderTimeOutHandler(long timeInterval) throws OrderException {
		logger.info("超时订单处理 【timeInterval:{}】",timeInterval);
		//更新当前系统中所有超时订单
		try {
			orderBaseMapper.updateTimeOutOrder(timeInterval);
		} catch (Exception e) {
			logger.error("超时订单处理错误",e);
			throw new OrderException(OrderExceptionEnum.ORDER_STATE_CANGE_ERROR, "超时订单处理错误");
		}
	}
}
