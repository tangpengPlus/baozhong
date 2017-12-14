package com.bz.openweb.web.controller.scanorder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user/order")
public class ScanOrderController {

	
	
	@GetMapping(value="/scanorder")
	public ModelAndView scanOrder(ModelAndView mv) {
		
		
		return mv;
	}
}
