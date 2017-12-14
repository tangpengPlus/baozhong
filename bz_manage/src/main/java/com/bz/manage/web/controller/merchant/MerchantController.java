package com.bz.manage.web.controller.merchant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.framework.pojo.page.PageBean;
import com.bz.manage.service.merchant.MerchantService;

@Controller
@RequestMapping(value="merchant/shop")
public class MerchantController {

	public static final Log log = LogFactory.getLog(MerchantController.class);
	
	@Autowired
	private MerchantService merchantService;
	
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("查询客户文件列表");
		try {
			mv.addObject("merchantFile", merchantService.selectListPage(pb));
			mv.setViewName("merchant/shop/shoplist");
		}catch (Exception e) {
			log.error("查询列表错误", e);
			e.printStackTrace();
		}
		return mv;
	}
}
