package com.bz.pay.core.service.pay.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.service.merchant.MerchantRedCouponService;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;
/**
 *       
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:51:59
 * 描述:支付成功优惠券相关处理
 * 备注:
 */
@Service
public class PayNotifyActivityService implements BzObserver<PayNotifyRequest>{
	
    private final Logger logger=LoggerFactory.getLogger(PayNotifyActivityService.class);
	
	@Reference(version="1.0.0")
	private MerchantRedCouponService merchantRedCouponService;
	@Override
	public PayNotifyRequest handle(PayNotifyRequest data) throws BzBaseException {
		logger.info("支付回调红包券发送处理PayNotifyRequest:{}",data);
		//派送红包
		return null;
	}

	@Override
	public boolean isHandle(PayNotifyRequest data) {
		
		return true;
	}

}
