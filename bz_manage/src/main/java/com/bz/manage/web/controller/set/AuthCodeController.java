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

import com.bz.manage.model.test.AuthCode;

/**
 * 作者: 胡竞
 * 描述: 设置验证码控制
 * 创建时间:2017年10月11日 下午4:28:58
 * 修改备注:
 */
@Controller
@RequestMapping(value="/system/admin")
public class AuthCodeController {

	Log log=LogFactory.getLog(EmailController.class);
	
	
	@GetMapping(value="/authcode")
	public ModelAndView authCode(ModelAndView mv,HttpSession session,AuthCode code) {
		log.info("进入验证码设置页面");
		code.setCode1("前台登录");
		code.setCode2("前台注册");
		code.setCode3("商品咨询");
		code.setCode4("后台登录");
		mv.addObject("authcode",code);
		mv.setViewName("system/sitesSet/authCodeSet");
		return mv;
	}
	
	
	@PostMapping(value="/authcode")
	public ModelAndView authCode(ModelAndView mv,@Valid AuthCode code,BindingResult result,HttpSession session) {
		log.info("修改验证码设置");
		if(result.hasErrors()) {
			log.info("修改失败");
			mv.setViewName("system/sitesSet/authCodeSet");
		}else {
			mv.addObject("authcode",code);
			mv.setViewName("redirect:authcode");
		}
		return mv;
	}
}
