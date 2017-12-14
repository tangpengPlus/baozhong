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
import com.bz.manage.service.paying.ClassifyService;

/**
 * 
 * 作者: 兰俊
 * 描述: 分类管理控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月16日下午2:06:25
 */
@Controller
@RequestMapping("system/classify")
public class ClassifyController {

	private Log log = LogFactory.getLog(ClassifyController.class);
	
	@Autowired
	private ClassifyService classifyService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取分类管理列表
	 * 创建时间:2017年10月16日下午2:09:08
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开分类管理页面-------");
		try {
			mv.addObject("classifyList", classifyService.getClassifyAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/classify/classifylist");
		} catch (Exception e) {
			log.error("-------打开分类管理页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件获取分类管理列表
	 * 创建时间:2017年10月16日下午2:13:18
	 * 修改备注:
	 */
	@PostMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开分类管理条件查询页面-------");
		try {
			mv.addObject("classifyList", classifyService.getClassifyAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/classify/classifylist");
		} catch (Exception e) {
			log.error("-------打开分类管理条件查询页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 打开分类管理增加页面
	 * 创建时间:2017年10月16日下午2:18:26
	 * 修改备注:
	 */
	@GetMapping("/add")
	public ModelAndView add(ModelAndView mv, HttpSession session) {
		log.info("-------打开分类管理增加页面-------");
		try {
			mv.addObject("classify", new Select());
			mv.setViewName("system/paying/classify/classifyinfo");
		} catch (Exception e) {
			log.error("-------打开分类管理增加页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 增加分类控制
	 * 创建时间:2017年10月16日下午2:20:36
	 * 修改备注:
	 */
	@PostMapping("/add")
	public ModelAndView add(@Valid Select s,BindingResult br,ModelAndView mv, HttpSession session) {
		log.info("-------开始增加分类-------");
		if(br.hasErrors()) {
			mv.addObject("classify", s);
			mv.setViewName("system/paying/classify/classifyinfo");
		}else {
			try {
				classifyService.save(s);
				mv.setViewName("redirect:list");
			} catch (Exception e) {
				log.error("-------增加分类失败-------");
				e.printStackTrace();
			}
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 打开修改分类页面
	 * 创建时间:2017年10月16日下午2:23:26
	 * 修改备注:
	 */
	@GetMapping("/update")
	public ModelAndView update(Integer id,ModelAndView mv, HttpSession session) {
		log.info("-------打开分类修改页面-------");
		try {
			Select s = classifyService.getClassifyById(id);
			mv.addObject("classify", s);
			mv.setViewName("system/paying/classify/classifyinfo");
		} catch (Exception e) {
			log.error("-------打开分类修改页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 修改分类控制
	 * 创建时间:2017年10月16日下午2:25:26
	 * 修改备注:
	 */
	@PostMapping("/update")
	public ModelAndView update(@Valid Select s,BindingResult br,ModelAndView mv, HttpSession session) {
		log.info("-------开始修改分类-------");
		if(br.hasErrors()) {
			mv.addObject("classify", s);
			mv.setViewName("system/paying/classify/classifyinfo");
		}else {
			try {
				classifyService.update(s);
				mv.setViewName("redirect:list");
			} catch (Exception e) {
				log.error("-------修改分类失败-------");
				e.printStackTrace();
			}
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 删除单个分类信息
	 * 创建时间:2017年10月16日下午2:27:49
	 * 修改备注:
	 */
	@GetMapping("/del")
	public ModelAndView del(ModelAndView mv,Integer id) {
		log.info("-------开始删除分类信息-------");
		try {
			classifyService.delClassifyById(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------删除单个分类信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 批量删除分类信息
	 * 创建时间:2017年10月16日下午2:29:17
	 * 修改备注:
	 */
	@GetMapping("/dels")
	public ModelAndView dels(ModelAndView mv,String id) {
		log.info("-------开始批量删除分类信息-------");
		try {
			classifyService.delClassifyByIds(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------批量删除分类信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
}
