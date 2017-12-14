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

import com.bz.manage.model.test.OpenShopSet;


/**
 * 
 * 作者: 胡竞
 * 描述: 开店设置控制
 * 创建时间:2017年10月12日 上午10:05:51
 * 修改备注:
 */
@Controller
@RequestMapping(value="/system/admin")
public class OpenShopSetController {

	Log log=LogFactory.getLog(OpenShopSetController.class);
	
	/**
	   * 作者: 胡竞
	   * 描述: 进入开启商店设置页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日上午10:10:47
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/openshopset")
	public ModelAndView openShop(ModelAndView mv,HttpSession session,OpenShopSet set) {
		log.info("进入开启商店设置页面");
		set.setApplyOpenId(0);
		mv.addObject("shopset",set);
		mv.setViewName("system/sitesSet/openshopset");
		return mv;
	}
	
	/**
	   * 作者:胡竞
	   * 描述: 修改开启商店设置
	   * 版本: version 1.0.0
	   * 时间: 2017年10月12日上午10:17:19
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@PostMapping(value="/openshopset")
	public ModelAndView openShop(ModelAndView mv,HttpSession session,@Valid OpenShopSet set,BindingResult result) {
		log.info("修改开启商店设置");
		if (result.hasErrors()) {
			log.info("修改有误");
			mv.setViewName("system/sitesSet/openshopset");
		} else {
			log.info("修改成功");
			mv.addObject("openshopset", set);
			mv.setViewName("redirect:openshopset");
		}
		
		return mv;
	}
	
	
}
