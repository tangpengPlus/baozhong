package com.bz.pay.core.service.pay.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.framework.error.exception.PayException;
import com.bz.open.core.service.pay.PayNotifyService;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;
import com.bz.pay.core.service.pay.recod.PayRecordLogService;
import com.bz.pay.core.service.pay.subject.PayNotifySubject;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:38:51
 * 描述:支付回调开放服务处理
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.pay.PayNotifyService.class)
public class PayNotifyServiceImpl implements PayNotifyService{
    private final Logger logger=LoggerFactory.getLogger(PayNotifyServiceImpl.class);
	
    @Autowired
    private PayRecordLogService payRecordLogService;
    @Autowired
    private PayNotifySubject payNotifySubject;
	@Override
	public void payNotify(PayNotifyRequest payNotifyRequest) throws PayException {
		logger.info("支付成功回调处理服务，回调参数【PayNotifyRequest】:{}",payNotifyRequest);
		//处理支付状态服务
		payRecordLogService.updatePayRecordState(payNotifyRequest.getOrderNumber(), Integer.valueOf(payNotifyRequest.getOrderStateEnum().getKey()));
	    //通知下发
		payNotifySubject.execute(payNotifyRequest);
	}
}
