package com.bz.pay.core.service.pay.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.service.weixin.WeixinTemplateMessageService;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;
import com.bz.open.core.vo.request.weixin.WeixinTemplateMessageRequest;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午3:45:40
 * 描述:订单支付回调通知处理
 * 备注:
 */
@Service
public class PayNotifyNoticeService implements BzObserver<PayNotifyRequest>{

	 private final Logger logger=LoggerFactory.getLogger(PayNotifyNoticeService.class);
	 
	 @Reference
	 private WeixinTemplateMessageService weixinTemplateMessageService;
	 
	 @Reference
	 private UserBaseService userBaseService;
	 
	 @Reference
	 private MerchantBaseService merchantBaseService;
	 
	 @Override
	public PayNotifyRequest handle(PayNotifyRequest data) throws BzBaseException {
		logger.info("支付成功回调:【订单支付回调通知处理】参数详情【PayNotifyRequest】:{}",data);
		
		UserBaseResponseVo baseResponseVo= userBaseService.getUserBaseInfo(data.getPayUserId());
		/**
		 * 发送模板消息给扫码用户
		 */
		WeixinTemplateMessageRequest userMeeage=new WeixinTemplateMessageRequest();
	    
		userMeeage.setOpenId(baseResponseVo.getWechatopenid());
		
		
		
		weixinTemplateMessageService.sendWeixinTemplateMessage(userMeeage);
		
		
		return data;
	}

	@Override
	public boolean isHandle(PayNotifyRequest data) {
		
		return true;
	}

}
