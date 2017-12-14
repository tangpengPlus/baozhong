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
import com.bz.manage.model.test.ShopManage;

/**
* @ClassName: ShopManageController 
* @Description: TODO(店铺管理页面控制) 
* @author 胡竞
* @date 2017年10月17日 上午9:44:01 
*
 */
@Controller
@RequestMapping(value="/system/shopset")
public class ShopManageController {

	private static final Log log=LogFactory.getLog(ShopManageController.class);
	
	
	/**
	* @作者 胡竞
	* @Title: selectShop 
	* @Description: TODO(访问商铺管理页面) 
	* @param @param mv
	* @param @param manage
	* @param @param pb
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/shopmanage")
	public ModelAndView selectShop(ModelAndView mv,ShopManage manage,PageBean pb) {
		log.info("进入商铺管理页面");
		
		manage.setId(1);
		manage.setShopkeeper("胡竞");
		manage.setShopName("商店");
		manage.setAddress("重庆");
		manage.setGrade("普通商铺");
		manage.setStatus(0);
		mv.addObject("pagebean",pb);
		mv.addObject("manage",manage);
		mv.setViewName("system/shopset/shopmanage");
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: add 
	* @Description: TODO(访问添加商铺页面) 
	* @param @param mv
	* @param @param manage
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/addmanage")
	public ModelAndView add(ModelAndView mv,ShopManage manage) {
		log.info("进入添加页面");
		mv.addObject("manage",manage);
		mv.setViewName("system/shopset/shopmanageinfo");
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: add 
	* @Description: TODO(添加商铺) 
	* @param @param mv
	* @param @param manage
	* @param @param bindingResult
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@PostMapping(value="/addmanage")
	public ModelAndView add(ModelAndView mv,@Valid ShopManage manage,BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			log.info("添加失败" +bindingResult.getAllErrors());
			mv.setViewName("system/shopset/shopmanageinfo");
		} else {
			log.info("添加成功");
			mv.addObject("manage",manage);
			mv.setViewName("redirect:shopmanage");
		}
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: update 
	* @Description: TODO(访问修改商铺页面) 
	* @param @param mv
	* @param @param manage
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/updatemanage")
	public ModelAndView update(ModelAndView mv,ShopManage manage) {
		log.info("进入修改页面");
		manage.setId(1);
		manage.setShopkeeper("胡竞");
		manage.setShopName("小卖部");
		manage.setAddress("重庆");
		manage.setGrade("普通商铺");
		manage.setStatus(0);
		mv.addObject("manage",manage);
		mv.setViewName("system/shopset/shopmanageinfo");
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: update 
	* @Description: TODO(修改商铺) 
	* @param @param mv
	* @param @param manage
	* @param @param result
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@PostMapping(value="/updatemanage")
	public ModelAndView update(ModelAndView mv,@Valid ShopManage manage,BindingResult result) {
		if (result.hasErrors()) {
			log.info("修改商铺失败"+result.getAllErrors());
			mv.setViewName("system/shopset/shopmanageinfo");
		} else {
			log.info("修改商铺成功");
			mv.addObject("manage",manage);
			mv.setViewName("redirect:shopmanage");
		}
		return mv;
	}
	
	
	/**
	* @作者 胡竞
	* @Title: delete 
	* @Description: TODO(删除商铺) 
	* @param @param mv
	* @param @param id
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/deletemanage")
	public ModelAndView delete(ModelAndView mv,Integer id ) {
		
		return mv;
	}
	
	
	
	
	
	
	
	
}
