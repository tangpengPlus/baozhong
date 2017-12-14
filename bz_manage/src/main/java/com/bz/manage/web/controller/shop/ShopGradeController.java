package com.bz.manage.web.controller.shop;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.model.test.ShopGrade;

/**
 * 
* @ClassName: ShopGradeController 
* @Description: TODO(商铺等级设置页面控制) 
* @author 胡竞
* @date 2017年10月17日 上午9:38:16 
*
 */
@Controller
@RequestMapping(value="/system/shopset")
public class ShopGradeController {

	private static final Log log=LogFactory.getLog(ShopGradeController.class);
	
	
	/**
	* @作者 胡竞
	* @Title: shopGrade 
	* @Description: TODO(查询并显示商铺等级页面) 
	* @param @param mv
	* @param @param grade
	* @param @param pb
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/select")
	public ModelAndView shopGrade(ModelAndView mv,ShopGrade grade,PageBean pb) {
		log.info("进入商铺等级设置页面");
		
		grade.setGradeId(1);
		grade.setGradeName("普通商铺");
		grade.setAllowAmount("不限");
		grade.setUploadSize("不限");
		grade.setModelAmount(12);
		grade.setChargeStandard(0);
		grade.setIsAudit(0);
		grade.setIsdelete(0);
		mv.addObject("pagebean",pb);
		mv.addObject("shopgrade", grade);
		mv.setViewName("system/shopset/shopgrade");
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: addGrade 
	* @Description: TODO(访问添加店铺等级页面) 
	* @param @param mv
	* @param @param grade
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/addgrade")
	public ModelAndView addGrade(ModelAndView mv,ShopGrade grade) {
		log.info("进入商铺等级添加页面");
		mv.addObject("addgrade",grade);
		mv.setViewName("system/shopset/shopgradeinfo");
		return mv;
	}
	
	/**
	 * 
	* @作者 胡竞
	* @Title: addGrade 
	* @Description: TODO(添加商铺等级) 
	* @param @param mv
	* @param @param grade
	* @param @param result
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@PostMapping(value="/addgrade")
	public ModelAndView addGrade(ModelAndView mv,@Valid ShopGrade grade,BindingResult result) {
		if (result.hasErrors()) {
			log.info("添加商铺等级失败"+result.getAllErrors());
			mv.setViewName("system/shopset/shopgradeinfo");
		} else {
			log.info("添加商铺等级成功");
			mv.addObject("addgrade",grade);
			mv.setViewName("redirect:select");
		}
		return mv;
	}
	
	
	
	/**
	* @作者 胡竞
	* @Title: updateGrade 
	* @Description: TODO(访问修改商铺等级页面) 
	* @param @param mv
	* @param @param grade
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/updategrade")
	public ModelAndView updateGrade(ModelAndView mv,ShopGrade grade) {
		log.info("进入修改商铺等级页面");
		mv.addObject("addgrade", grade);
		mv.setViewName("system/shopset/shopgradeinfo");
		return mv;
	}

	/**
	* @作者 胡竞
	* @Title: updateGrade 
	* @Description: TODO(修改商铺等级) 
	* @param @param mv
	* @param @param grade
	* @param @param result
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@PostMapping(value="/updategrade")
	public ModelAndView updateGrade(ModelAndView mv,@Valid ShopGrade grade,BindingResult result) {
		if (result.hasErrors()) {
			log.info("修改商铺等级失败"+result.getAllErrors());
			mv.setViewName("system/shopset/shopgradeinfo");
		} else {
			log.info("修改商铺等级");
			mv.addObject("updategrade", grade);
			mv.setViewName("redirect:select");
		}
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: deleteGrade 
	* @Description: TODO(删除商铺等级) 
	* @param @param mv
	* @param @param id
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping("/deletegrade")
	public ModelAndView deleteGrade(ModelAndView mv,Integer id) {
		log.info("删除商铺等级");
		mv.setViewName("redirect:select");
		return mv;
	}
	
	
	
}
