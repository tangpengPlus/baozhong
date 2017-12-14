package com.bz.manage.web.controller.paying;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.model.test.Select;
import com.bz.manage.service.paying.BrandService;

/**
 * 
 * 作者: 兰俊
 * 描述: 品牌团控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月16日下午1:42:28
 */
@Controller
@RequestMapping("system/brand")
public class BrandController {

	private Log log = LogFactory.getLog(BrandController.class);
	
	@Autowired
	private BrandService brandService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取品牌团列表
	 * 创建时间:2017年10月16日下午1:33:08
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开品牌团页面-------");
		try {
			mv.addObject("brandList", brandService.getBrandAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/brand/brandlist");
		} catch (Exception e) {
			log.error("-------打开品牌团页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件获取品牌团列表
	 * 创建时间:2017年10月16日下午1:35:08
	 * 修改备注:
	 */
	@PostMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开品牌团条件查询页面-------");
		try {
			mv.addObject("brandList", brandService.getBrandAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/brand/brandlist");
		} catch (Exception e) {
			log.error("-------打开品牌团条件查询页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取待审核列表
	 * 创建时间:2017年10月16日下午1:51:16
	 * 修改备注:
	 */
	@GetMapping("/check")
	public ModelAndView check(ModelAndView mv,PageBean pb) {
		log.info("-------打开待审核页面-------");
		try {
			mv.addObject("checkList", brandService.getBrandCheckAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/brand/checkPendinglist");
		} catch (Exception e) {
			log.error("-------打开待审核页面失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 打开品牌团增加页面
	 * 创建时间:2017年10月16日下午1:41:26
	 * 修改备注:
	 */
	@GetMapping("/add")
	public ModelAndView add(ModelAndView mv, HttpSession session) {
		log.info("-------打开品牌团增加页面-------");
		try {
			mv.addObject("brand", new Select());
			mv.setViewName("system/paying/brand/brandinfo");
		} catch (Exception e) {
			log.error("-------打开品牌团增加页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 增加品牌团控制
	 * 创建时间:2017年10月16日下午1:44:26
	 * 修改备注:
	 */
	@PostMapping("/add")
	public ModelAndView add(@Valid Select s,BindingResult br,ModelAndView mv, HttpSession session) {
		log.info("-------开始增加品牌团-------");
		if(br.hasErrors()) {
			mv.addObject("brand", s);
			mv.setViewName("system/paying/brand/brandinfo");
		}else {
			try {
				brandService.save(s);
				mv.setViewName("redirect:list");
			} catch (Exception e) {
				log.error("-------增加品牌团失败-------");
				e.printStackTrace();
			}
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 打开修改品牌团页面
	 * 创建时间:2017年10月16日下午1:47:26
	 * 修改备注:
	 */
	@GetMapping("/update")
	public ModelAndView update(Integer id,ModelAndView mv, HttpSession session) {
		log.info("-------打开品牌团修改页面-------");
		try {
			Select s = brandService.getBrandById(id);
			mv.addObject("brand", s);
			mv.setViewName("system/paying/brand/brandinfo");
		} catch (Exception e) {
			log.error("-------打开品牌团修改页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 修改品牌团控制
	 * 创建时间:2017年10月16日下午1:49:26
	 * 修改备注:
	 */
	@PostMapping("/update")
	public ModelAndView update(@Valid Select s,BindingResult br,ModelAndView mv, HttpSession session) {
		log.info("-------开始修改品牌团-------");
		if(br.hasErrors()) {
			mv.addObject("brand", s);
			mv.setViewName("system/paying/brand/brandinfo");
		}else {
			try {
				brandService.update(s);
				mv.setViewName("redirect:list");
			} catch (Exception e) {
				log.error("-------修改品牌团失败-------");
				e.printStackTrace();
			}
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 删除单个品牌团信息
	 * 创建时间:2017年10月16日下午1:58:49
	 * 修改备注:
	 */
	@GetMapping("/del")
	public ModelAndView del(ModelAndView mv,Integer id) {
		log.info("-------开始删除单个品牌团信息-------");
		try {
			brandService.getBrandById(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------删除单个品牌团信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 批量删除品牌团信息
	 * 创建时间:2017年10月16日下午2:02:49
	 * 修改备注:
	 */
	@GetMapping("/dels")
	public ModelAndView dels(ModelAndView mv,String id) {
		log.info("-------开始批量删除品牌团信息-------");
		try {
			brandService.delBrandByIds(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------批量删除品牌团信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
}
