package com.bz.manage.web.controller.set;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.test.WeChatInterfaceSet;

@Controller
@RequestMapping(value="/system/admin")
public class WeChatInterfaceSetController {
	private static final Log log=LogFactory.getLog(WeChatInterfaceSetController.class);
	
	
	/**
	   * 作者:胡竞
	   * 描述: 进入微信接口配置页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日下午6:29:22
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/test")
	public ModelAndView weChatInterfaceSet(ModelAndView mv,WeChatInterfaceSet set) {
		
		mv.setViewName("system/testStatement/month");
		return mv;
	}
	
	/**
	   * 作者:胡竞
	   * 描述: 修改微信接口配置
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日下午6:33:21
	   * @param request
	   * @return
	   * ModelAndView
	 */
	/*@PostMapping(value="/wechatinterfaceset")
	public ModelAndView weChatInterfaceSet(ModelAndView mv,@Valid WeChatInterfaceSet set,BindingResult result) {
		if (result.hasErrors()) {
			log.info("修改失败");
			mv.setViewName("system/testStatement/test");
		} else {
			log.info("修改微信接口配置成功");
			mv.addObject("interfaceset",set);
			mv.setViewName("redirect:wechatinterfaceset");
		}
		return mv;
	}*/
}
