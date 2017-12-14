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

import com.bz.manage.model.test.Email;

/**
 * 
 * 作者: 胡竞
 * 描述: Email设置页面控制
 * 创建时间:2017年10月11日 下午4:21:37
 * 修改备注:
 */
@Controller
@RequestMapping(value="/system/admin")
public class EmailController {

	Log log=LogFactory.getLog(EmailController.class);
	
	
	/**
	   * 作者:胡竞
	   * 描述: 进入修改邮件服务器的页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月11日下午2:48:51
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/email")
	public ModelAndView emailSet(ModelAndView mv,HttpSession session,Email e) {
		log.info("进入邮箱设置页面");
		
		//测试邮箱设置数据
		e.setSendMode(1);
		e.setSmtpServers("smtp.163.com");
		e.setSmtpPort("25");
		e.setSenderEmail("15881881925@163.com");
		e.setSmtpName("15881881925");
		e.setSmptPassword("123456");
		e.setTestEmail("690230433@qq.com");
		mv.addObject("email",e);
		mv.setViewName("system/sitesSet/emailSet");
		return mv;
	}
	
	/**
	 * 
	   * 作者:胡竞
	   * 描述: 修改邮箱设置
	   * 版本: version 1.0.0
	   * 时间: 2017年10月11日下午3:34:30
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@PostMapping(value="/email")
	public ModelAndView emailSet(ModelAndView mv,@Valid Email email,BindingResult result,HttpSession session) {
		log.info("修改邮箱设置");
		if(result.hasErrors()) {
			log.info("修改邮箱设置失败");
			mv.setViewName("system/sitesSet/emailSet");
		}else {
			mv.addObject("email",email);
			mv.setViewName("redirect:/email");
		}
		return mv;
	}
}
