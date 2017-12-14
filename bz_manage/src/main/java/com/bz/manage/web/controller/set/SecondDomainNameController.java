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

import com.bz.manage.model.test.SecondDomainName;

/**
 * 作者: 胡竞
 * 描述: 二级域名设置控制
 * 创建时间:2017年10月12日 下午5:15:54
 * 修改备注:
 */
@Controller
@RequestMapping(value="/system/admin")
public class SecondDomainNameController {

	Log log=LogFactory.getLog(SecondDomainNameController.class);
	
	/**
	   * 作者:胡竞
	   * 描述: 进入二级域名设置页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日下午5:16:20
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/seconddomain")
	public ModelAndView secondDomain(ModelAndView mv,SecondDomainName name,HttpSession session) {
		log.info("进入二级域名设置页面");
		
		name.setIsdelete(0);
		name.setSuffix("");
		name.setReserve("www");
		name.setLength("3-12");
		mv.addObject("secondname",name);
		mv.setViewName("system/sitesSet/seconddomainname");
		return mv;
	}
	
	/**
	   * 作者:胡竞
	   * 描述: 修改二级域名设置
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日下午5:16:43
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@PostMapping(value="/seconddomain")
	public ModelAndView secondDomain(ModelAndView mv,@Valid SecondDomainName name,BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			log.info("修改失败");
			mv.setViewName("system/sitesSet/seconddomainname");
		} else {
			mv.addObject("secondname",name);
			mv.setViewName("redirect:seconddomain");
		}
		return mv;
	}
}
