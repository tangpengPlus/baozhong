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
import com.bz.manage.model.test.SellerGrade;

/**
 * 作者: 胡竞
 * 描述: 卖家信用等级设置控制
 * 创建时间:2017年10月12日 下午2:47:01
 * 修改备注:
 */
@Controller
@RequestMapping(value="/system/admin")
public class SellerGradeController2 {

	Log log=LogFactory.getLog(SellerGradeController2.class);
	/**
	   * 作者: 胡竞
	   * 描述: 进入卖家信用等级设置的页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日下午2:48:44
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/sellergrade")
	public ModelAndView buyerGrade(ModelAndView mv,HttpSession session,SellerGrade grade) {
		log.info("进入卖家信用等级设置");
		
		grade.setGrade(0);
		mv.addObject("sellergrade", grade);
		mv.setViewName("system/sitesSet/sellergrade");
		return mv;
	}
	
	@PostMapping(value="/sellergrade")
	public ModelAndView buyerGrade(ModelAndView mv,@Valid SellerGrade grade,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			log.info("修改失败");
			mv.setViewName("system/sitesSet/sellergrade");
		}else { 
			log.info("卖家等级设置修改成功");
			mv.addObject("sellergrade",grade);
			mv.setViewName("redirect:sellergrade");
		}
		return mv;
	}
}
