package com.bz.manage.web.controller.deal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.model.test.Select;
import com.bz.manage.service.deal.EvaluateService;

/**
 * 
 * 作者: 兰俊
 * 描述: 评价管理控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月11日上午9:40:58
 */
@Controller
@RequestMapping("system/evaluate")
public class EvaluateController {

	private static Log log = LogFactory.getLog(EvaluateController.class);
	
	@Autowired
	private EvaluateService evaluateService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取买家评价列表
	 * 创建时间:2017年10月11日上午9:41:24
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开买家评价列表页面-------");
		try {
			mv.addObject("evaluateList", evaluateService.getEvaluateAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/evaluatelist");
		} catch (Exception e) {
			log.error("-------打开买家评价列表页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	} 
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据获取买家评价列表
	 * 创建时间:2017年10月11日上午10:41:24
	 * 修改备注:
	 */
	@PostMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开买家评价列表页面-------");
		try {
			mv.addObject("evaluateList", evaluateService.getEvaluateAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/evaluatelist");
		} catch (Exception e) {
			log.error("-------打开买家评价列表页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取卖家评价列表
	 * 创建时间:2017年10月12日下午6:23:10
	 * 修改备注:
	 */
	@GetMapping("/seller")
	public ModelAndView seller(ModelAndView mv,PageBean pb) {
		log.info("-------打开卖家评价列表页面-------");
		try {
			mv.addObject("orderList", evaluateService.getSellerAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/evaluate/sellerlist");
		} catch (Exception e) {
			log.error("-------打开买家评价列表页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据获取卖家评价列表
	 * 创建时间:2017年10月12日下午6:25:10
	 * 修改备注:
	 */
	@PostMapping("/seller")
	public ModelAndView seller(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开卖家评价列表页面-------");
		try {
			mv.addObject("orderList", evaluateService.getSellerAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/evaluate/sellerlist");
		} catch (Exception e) {
			log.error("-------打开买家评价列表页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	
	
	
	
	
	
}
