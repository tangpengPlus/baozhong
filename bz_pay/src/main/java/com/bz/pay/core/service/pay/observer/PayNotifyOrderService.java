package com.bz.pay.core.service.pay.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.service.order.BaseOrderService;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:50:32
 * 描述:支付回调订单相关数据处理
 * 备注:
 */
@Service
public class PayNotifyOrderService implements BzObserver<PayNotifyRequest>{
	 
	@Reference(version="1.0.0")
	private BaseOrderService baseOrderService;
	
	private final Logger logger=LoggerFactory.getLogger(PayNotifyOrderService.class);

	@Override
	public PayNotifyRequest handle(PayNotifyRequest data) throws BzBaseException {
		logger.info("支付成功回调:【订单状态相关处理】参数详情【PayNotifyRequest】:{}",data);
		baseOrderService.changeOrderState(data.getOrderNumber(), data.getOrderStateEnum(), data.getOrderSign());
		return data;
	}

	@Override
	public boolean isHandle(PayNotifyRequest data) {
		
		return true;
	}

}
