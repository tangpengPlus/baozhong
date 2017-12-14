package com.bz.manage.web.controller.deal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.service.deal.RefundService;

/**
 * 
 * 作者: 兰俊
 * 描述: 退款业务控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月11日上午10:34:08
 */
@Controller
@RequestMapping("system/refund")
public class RefundController {

	private static Log log = LogFactory.getLog(RefundController.class);
	
	@Autowired
	private RefundService refundService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取退款列表
	 * 创建时间:2017年10月11日上午10:34:46
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开退款页面-------");
		try {
			mv.addObject("refundList", refundService.getRefundAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/deal/refundlist");
		} catch (Exception e) {
			log.error("-------打开退款页面失败-------");
			e.printStackTrace();
		}
		
		return mv;
		
	}
}
