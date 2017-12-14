package com.bz.manage.web.controller.deal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.service.deal.SalesmanService;

/**
 * 
 * 作者: 兰俊
 * 描述: 业务员管理控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月11日上午10:39:17
 */
@Controller
@RequestMapping("system/salesman")
public class SalesmanController {

	private static Log log = LogFactory.getLog(SalesmanController.class);
	
	@Autowired
	private SalesmanService salesmanService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取业务员列表
	 * 创建时间:2017年10月11日上午10:46:07
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv, PageBean pb) {
		log.info("-------打开业务员管理页面-------");
		try {
			mv.addObject("salesmanList", salesmanService.getSalesmanAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/salesmanlist");
		} catch (Exception e) {
			log.error("-------打开业务员管理页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	} 
}
