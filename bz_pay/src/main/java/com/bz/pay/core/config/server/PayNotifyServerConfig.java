package com.bz.pay.core.config.server;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;
import com.bz.pay.core.service.pay.observer.PayNotifyActivityService;
import com.bz.pay.core.service.pay.observer.PayNotifyCapitalChangeService;
import com.bz.pay.core.service.pay.observer.PayNotifyNoticeService;
import com.bz.pay.core.service.pay.observer.PayNotifyOrderService;
import com.bz.pay.core.service.pay.subject.PayNotifySubject;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午4:27:06
 * 描述:支付回调服务配置
 * 备注:
 */
@Configuration
public class PayNotifyServerConfig {

	private final Logger logger=LoggerFactory.getLogger(PayNotifyServerConfig.class);
	
	@Autowired
	private PayNotifyActivityService payNotifyActivityService;
	
	@Autowired
	private PayNotifyCapitalChangeService payNotifyCapitalChangeService;
	
	@Autowired
	private PayNotifyNoticeService payNotifyNoticeService;
	
	@Autowired
	private PayNotifyOrderService payNotifyOrderService;
	
	@Bean
	public PayNotifySubject createPayNotifySubject() {
		logger.info("》》》》》》》》》初始化订单回调观察者通知《《《《《《《《《《《《《《");
		PayNotifySubject payNotifySubject=new PayNotifySubject();
		List<BzObserver<PayNotifyRequest>> observerList=new  ArrayList<>();
		/*支付回调活动服务相关实现*/
		observerList.add(payNotifyActivityService);
		/*支付回调资金变动相关实现*/
		observerList.add(payNotifyCapitalChangeService);
		/*支付回调消息相关服务实现*/
		observerList.add(payNotifyNoticeService);
		/*支付回调订单服务实现*/
		observerList.add(payNotifyOrderService);
		payNotifySubject.setObserverList(observerList); 
		return payNotifySubject;
	}
}
