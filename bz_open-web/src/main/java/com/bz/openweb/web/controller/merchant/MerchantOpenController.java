package com.bz.openweb.web.controller.merchant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月12日上午10:13:54
 * 描述:商户开放web端控制
 * 备注:
 */
@Controller
@RequestMapping(value="/v1/merchant")
public class MerchantOpenController {

	private  final Logger logger=LoggerFactory.getLogger(MerchantOpenController.class);
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月12日上午10:16:44
	 * 描述:打开商户注册页面
	 * 备注:
	 * @return
	 */
	@GetMapping(value="/regist")
	public ModelAndView registMerchant(ModelAndView mv,String ss){
		this.logger.info("打开商户注册页面");
		return mv;
	}
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月12日上午10:33:31
	 * 描述:
	 * 备注:
	 * @param mv
	 * @return
	 */
	@PostMapping(value="/regist")
	public ModelAndView registMerchant(ModelAndView mv){
		
		return mv;
	}
	
}
