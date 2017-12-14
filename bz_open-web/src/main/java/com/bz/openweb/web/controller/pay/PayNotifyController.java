package com.bz.openweb.web.controller.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 *  作者:唐鹏
 *  描述:支付回调控制
 *  备注:
 *  创建时间:2017年11月28日下午2:18:12
 */
@Controller
@RequestMapping(value="/pay")
public class PayNotifyController {

	private final Logger logger=LoggerFactory.getLogger(PayNotifyController.class);
	
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:微信支付回调
	 *  备注:
	 *  创建时间:2017年11月28日下午2:20:12
	 *  @return
	 */
	@PostMapping("/wxNotify")
	public String wxNotify() {
		logger.info("微信支付回调");
		return "";
	}
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:支付宝支付回掉
	 *  备注:
	 *  创建时间:2017年11月28日下午2:21:23
	 *  @return
	 */
	@PostMapping("/alNotify")
	public String alNotify() {
		logger.info("支付宝支付回调");
		
		
		return "";
	}
	
}
