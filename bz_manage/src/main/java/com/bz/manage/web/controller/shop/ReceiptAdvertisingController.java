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

import com.bz.manage.model.test.ReceiptAdvertising;
/**
 * 
* @ClassName: ReceiptAdvertisingController 
* @Description: TODO(小票时间添加控制) 
* @author 胡竞
* @date 2017年10月17日 上午9:36:16 
*
 */
@Controller
@RequestMapping(value="/system/shopset")
public class ReceiptAdvertisingController {

	private static final Log log =LogFactory.getLog(ReceiptAdvertisingController.class);
	
	
	/**
	* @作者 胡竞
	* @Title: addAdvertisingTime 
	* @Description: TODO(访问小票广告添加页面) 
	* @param @param mv
	* @param @param session
	* @param @param ra
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/addadvertisingtime")
	public ModelAndView addAdvertisingTime(ModelAndView mv , HttpSession session,ReceiptAdvertising ra) {
		
		log.info("进入小票广告页面");
		ra.setShopAccount("设计费");
		ra.setOpenTime("一季度");
		mv.addObject("addadvertisingtime",ra);
		mv.setViewName("system/shopset/addreceipttime");
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: addAdvertisingTime 
	* @Description: TODO(添加小票广告时间) 
	* @param @param mv
	* @param @param ra
	* @param @param result
	* @param @param session
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@PostMapping(value="/addadvertisingtime")
	public ModelAndView addAdvertisingTime(ModelAndView mv,@Valid ReceiptAdvertising ra,BindingResult result,HttpSession session) {
		
		if (result.hasErrors()) {
			log.info("添加小票广告时间失败"+result.getAllErrors());
			mv.setViewName("system/shopset/addreceipttime");
		} else {
			log.info("添加小票广告时间成功");
			mv.addObject("addadvertisingtime", ra);
			mv.setViewName("redirect:addadvertisingtime");
		}
		return mv;
	}
}
