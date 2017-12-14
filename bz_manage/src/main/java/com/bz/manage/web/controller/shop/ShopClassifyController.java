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

import com.bz.manage.model.test.ShopClassify;


/**
* @ClassName: ShopClassifyController 
* @Description: TODO(店铺分类页面控制) 
* @author 胡竞
* @date 2017年10月17日 上午9:37:43 
*
 */
@Controller 
@RequestMapping(value="/system/shopset")
public class ShopClassifyController {

	private static final Log log=LogFactory.getLog(ShopClassifyController.class);
	
	/**
	   * 作者: 胡竞
	   * 描述: 访问店铺分类的页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月16日上午11:56:49
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/classify")
	public ModelAndView classifySet(ModelAndView mv,HttpSession session) {
		log.info("进入商铺分类页面");
		ShopClassify classify =new ShopClassify();
		classify.setId(1);
		classify.setGrade(1);
		classify.setType(1);
		classify.setSuperior(1);
		classify.setName("出租车");
		classify.setIcopath("");
		classify.setIsdelete(0);
		classify.setAutoattach(0);
		mv.addObject("classify",classify);
		mv.setViewName("system/shopset/shopclassify");
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: updateClassify 
	* @Description: TODO(访问修改商铺分类页面) 
	* @param @param mv
	* @param @param classify
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/updateclassify")
	public ModelAndView updateClassify(ModelAndView mv,ShopClassify classify) {
		
		
		return mv;
	}
	
	
	
	}
