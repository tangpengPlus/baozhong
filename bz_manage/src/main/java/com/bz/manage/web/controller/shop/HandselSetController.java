package com.bz.manage.web.controller.shop;

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

import com.bz.manage.model.test.Handsel;

/**
 * 
* @ClassName: HandselSetController 
* @Description: TODO(添加保证金页面控制) 
* @author 胡竞
* @date 2017年10月17日 上午9:35:04 
*
 */
@Controller
@RequestMapping(value="/system/shopset")
public class HandselSetController {

	private static final Log log =LogFactory.getLog(HandselSetController.class);
	
	/**
	* 作者: 胡竞
	* 时间: 2017年10月16日下午9:57:32
	* @Title: addHandsel 
	* @Description: TODO(添加保证金页面) 
	* @param @param mv
	* @param @param session
	* @param @param handsel
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/addhandseltime")
	public ModelAndView addHandsel(ModelAndView mv,HttpSession session,Handsel handsel) {
		
		log.info("进入保证金访问页面");
		handsel.setShopName("zxczxc");
		handsel.setOpenTime("一季度");
		mv.addObject("handsel",handsel);
		mv.setViewName("system/shopset/handselshop");
		return mv;
	}
	
	/**
	 * 
	* 作者: 胡竞
	* 时间: 2017年10月16日下午9:58:20
	* @Title: addHandsel 
	* @Description: TODO(添加保证金) 
	* @param @param mv
	* @param @param handsel
	* @param @param result
	* @param @param session
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@PostMapping(value="/addhandseltime")
	public ModelAndView addHandsel(ModelAndView mv,@Valid Handsel handsel,BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			log.info("添加保证金失败"+result.getAllErrors());
			
			mv.setViewName("system/shopset/handselshop");
		} else {
			log.info("添加保证金成功");
			mv.addObject("handsel",handsel);
			mv.setViewName("redirect:/addhandseltime");
		}
		
		return mv;
	}
}
