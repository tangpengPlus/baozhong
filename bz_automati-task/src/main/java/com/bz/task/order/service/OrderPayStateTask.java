package com.bz.task.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.open.core.service.order.OrderTimeService;

/**
 * 
 *  作者:唐鹏
 *  描述:订单支付状态更改(任务)
 *  备注:
 *  创建时间:2017年11月27日上午11:01:45@EnableScheduling 
 */
@Component
public class OrderPayStateTask {

	private final Logger logger=LoggerFactory.getLogger(OrderPayStateTask.class);
	
	@Value("${order.time-out}")
	private long orderTimeOut;//订单超时时间
	
	@Reference(version="1.0.0")
	private OrderTimeService orderTimeService;
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:检查超时订单
	 *  备注:
	 *  创建时间:2017年11月27日下午1:40:17
	 */
	@Scheduled(cron="${task.order-timeOut}")
	public void checkTimeOutOrder() {
		logger.info("执行订单超时状态检测");
		orderTimeService.orderTimeOutHandler(orderTimeOut);
	}
	
}
