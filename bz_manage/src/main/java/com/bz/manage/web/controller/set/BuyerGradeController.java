package com.bz.manage.web.controller.set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.test.BuyerGrade;

/**
 * 作者: 胡竞
 * 描述: 账号等级设置控制
 * 创建时间:2017年10月12日 下午2:47:01
 * 修改备注:
 */
@Controller
@RequestMapping(value="/system/admin")
public class BuyerGradeController {

	Log log=LogFactory.getLog(BuyerGradeController.class);
	/**
	   * 作者: 胡竞
	   * 描述: 进入买家信用等级设置的页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日下午2:48:44
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/buyergrade")
	public ModelAndView buyerGrade(ModelAndView mv,HttpSession session,BuyerGrade grade) {
		log.info("进入买家信用等级设置");
		
		grade.setGrade(0);
		mv.addObject("buyergrade", grade);
		mv.setViewName("system/sitesSet/buyergrade");
		return mv;
	}
	
	@PostMapping(value="/buyergrade")
	public ModelAndView buyerGrade(ModelAndView mv,@Valid BuyerGrade grade,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			log.info("修改失败");
			mv.setViewName("system/sitesSet/buyergrade");
		}else { 
			mv.addObject("buyergrade",grade);
			mv.setViewName("redirect:buyergrade");
		}
		return mv;
	}
}
