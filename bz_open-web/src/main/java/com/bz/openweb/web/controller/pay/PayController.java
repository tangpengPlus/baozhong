package com.bz.openweb.web.controller.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.openweb.core.model.pay.PayRequest;

/**
 * 
 *  作者:唐鹏
 *  描述:支付控制
 *  备注:
 *  创建时间:2017年11月28日上午10:29:26
 */
@Controller
@RequestMapping(value="/pay")
public class PayController {

	private final Logger logger=LoggerFactory.getLogger(PayController.class);
	
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:打开支付页面
	 *  备注:
	 *  创建时间:2017年11月28日上午10:31:09
	 *  @param mv
	 *  @return
	 */
	@GetMapping("/handler")
	public ModelAndView pay(ModelAndView mv,PayRequest payRequest) {
		logger.info("处理支付请求PayRequest:{}",payRequest);
		return mv;
	} 
	
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:实现微信支付
	 *  备注:
	 *  创建时间:2017年11月28日上午10:50:41
	 *  @param mv
	 *  @return
	 */
	@GetMapping("/wxpay")
	public ModelAndView wxpay(ModelAndView mv) {
		logger.info("处理微信支付请求");
		return mv;
	}
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:实现支付宝支付
	 *  备注:
	 *  创建时间:2017年11月28日上午10:52:11
	 *  @param mv
	 *  @param form
	 *  @return
	 */
	@GetMapping("/alpay")
	public ModelAndView alpay(ModelAndView mv,String form) {
		logger.info("处理支付宝支付请求");
		return mv;
	}
}
