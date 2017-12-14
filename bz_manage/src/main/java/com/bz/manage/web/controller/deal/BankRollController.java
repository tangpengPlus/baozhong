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
import com.bz.manage.model.test.SelectW;
import com.bz.manage.service.deal.BankrollService;


/**
 * 
 * 作者: 兰俊
 * 描述: 资金流水管理控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月10日下午5:46:57
 */
@Controller
@RequestMapping("system/bankroll")
public class BankRollController {
	
	private static Log log = LogFactory.getLog(BankRollController.class);
	
	@Autowired
	private BankrollService bankrollService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取店铺资金列表
	 * 创建时间:2017年10月10日下午5:58:42
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开店铺资金页面-------");
		try {
			mv.addObject("bankrollList", bankrollService.getBankrollAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankrolllist");
		} catch (Exception e) {
			log.error("-------打开店铺资金页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
	

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件获取店铺资金列表
	 * 创建时间:2017年10月11日下午5:02:46
	 * 修改备注:
	 */
	@PostMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开店铺资金条件查询页面-------");
		try {
			mv.addObject("bankrollList", bankrollService.getBankrollAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankrolllist");
		} catch (Exception e) {
			log.error("-------打开店铺资金条件查询页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取资金流水列表
	 * 创建时间:2017年10月11日下午2:53:45
	 * 修改备注:
	 */
	@GetMapping("/CapitalFlow")
	public ModelAndView capitalFlowList(ModelAndView mv,PageBean pb) {
		log.info("-------打开资金流水详情页面-------");
		try {
			mv.addObject("capitalFlowList", bankrollService.getCapitalFlow());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankroll/capitalflowlist");
		} catch (Exception e) {
			log.error("-------打开资金流水页面失败");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	@PostMapping("/CapitalFlow")
	public ModelAndView capitalFlowList(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开资金流水详情条件查询页面-------");
		try {
			mv.addObject("capitalFlowList", bankrollService.getCapitalFlow(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankroll/capitalflowlist");
		} catch (Exception e) {
			log.error("-------打开资金流水条件查询页面失败");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取提现记录列表
	 * 创建时间:2017年10月11日下午2:59:02
	 * 修改备注:
	 */
	@GetMapping("/withdrawals")
	public ModelAndView withdrawalsList(ModelAndView mv,PageBean pb) {
		log.info("-------打开提现记录页面-------");
		try {
			mv.addObject("withdrawalsList", bankrollService.getWithdrawals());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankroll/withdrawalslist");
		} catch (Exception e) {
			log.error("-------打开提现记录页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件获取提现记录列表
	 * 创建时间:2017年10月11日下午3:59:02
	 * 修改备注:
	 */
	@PostMapping("/withdrawals")
	public ModelAndView withdrawalsList(ModelAndView mv,PageBean pb,SelectW s) {
		log.info("-------打开提现记录条件查询页面-------");
		try {
			mv.addObject("withdrawalsList", bankrollService.getWithdrawals(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankroll/withdrawalslist");
		} catch (Exception e) {
			log.error("-------打开提现记录条件查询页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取交易统计列表
	 * 创建时间:2017年10月11日下午3:05:40
	 * 修改备注:
	 */
	@GetMapping("/count")
	public ModelAndView countList(ModelAndView mv,PageBean pb) {
		log.info("-------打开交易统计页面-------");
		try {
			mv.addObject("withdrawalsList", bankrollService.getCount());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankroll/countlist");
		} catch (Exception e) {
			log.error("-------打开交易统计页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	@PostMapping("/count")
	public ModelAndView countList(ModelAndView mv,PageBean pb,String start,String end) {
		log.info("-------打开交易统计条件查询页面-------");
		try {
			if(start==""||end=="") {
				mv.setViewName("redirect:count");
			}else {
				mv.addObject("withdrawalsList", bankrollService.getCount(start,end));
				mv.addObject("pagebean", pb);
				mv.setViewName("system/deal/bankroll/countlist");
			}
		} catch (Exception e) {
			log.error("-------打开交易统计条件查询页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取店铺交易情况列表
	 * 创建时间:2017年10月11日下午3:06:23
	 * 修改备注:
	 */
	@GetMapping("/trade")
	public ModelAndView tradeList(ModelAndView mv,PageBean pb) {
		log.info("-------打开店铺交易情况页面-------");
		try {
			mv.addObject("withdrawalsList", bankrollService.getTrade());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/bankroll/tradelist");
		} catch (Exception e) {
			log.error("-------打开店铺交易情况页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	
	
}
