package com.bz.manage.web.controller.deal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.service.deal.RateService;

/**
 * 
 * 作者: 兰俊
 * 描述: 订单查询控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月11日上午9:52:55
 */
@Controller
@RequestMapping("system/rate")
public class RateController {

	private static Log log = LogFactory.getLog(RateController.class);
	
	@Autowired
	private RateService rateService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取费率列表
	 * 创建时间:2017年10月11日上午9:56:38
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开费率列表页面-------");
		try {
			mv.addObject("orderList", rateService.getRateAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/ratelist");
		} catch (Exception e) {
			log.error("-------打开费率列表页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	
	
}
