package com.bz.pay.core.service.pay.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
     
import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:48:14
 * 描述:支付回调资金变动服务
 * 备注:
 */
@Service
public class PayNotifyCapitalChangeService implements BzObserver<PayNotifyRequest>{

	 private final Logger logger=LoggerFactory.getLogger(PayNotifyCapitalChangeService.class);
	@Override
	public PayNotifyRequest handle(PayNotifyRequest data) throws BzBaseException {
		logger.info("支付成功回调处理商户资金变动");
		
		return null;
	}

	@Override
	public boolean isHandle(PayNotifyRequest data) {
		
		return false;
	}

}
