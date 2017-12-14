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
import com.bz.manage.service.paying.ActivityService;


/**
 * 
 * 作者: 兰俊
 * 描述: 活动管理控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月16日上午11:21:10
 */
@Controller
@RequestMapping("system/activity")
public class ActivityController {
	
	private Log log = LogFactory.getLog(ActivityController.class);
	
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取活动管理列表
	 * 创建时间:2017年10月16日上午11:33:08
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开活动管理页面-------");
		try {
			mv.addObject("activityList", activityService.getActivityAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/activity/activitylist");
		} catch (Exception e) {
			log.error("-------打开活动管理页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件获取活动管理列表
	 * 创建时间:2017年10月16日上午11:33:08
	 * 修改备注:
	 */
	@PostMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开活动管理条件查询页面-------");
		try {
			mv.addObject("activityList", activityService.getActivityAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/activity/activitylist");
		} catch (Exception e) {
			log.error("-------打开活动管理条件查询页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 打开增加活动页面
	 * 创建时间:2017年10月16日上午11:41:26
	 * 修改备注:
	 */
	@GetMapping("/add")
	public ModelAndView add(ModelAndView mv, HttpSession session) {
		log.info("-------打开活动增加页面-------");
		try {
			mv.addObject("activity", new Select());
			mv.setViewName("system/paying/activity/activityinfo");
		} catch (Exception e) {
			log.error("-------打开活动增加页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 增加活动控制
	 * 创建时间:2017年10月16日上午11:44:26
	 * 修改备注:
	 */
	@PostMapping("/add")
	public ModelAndView add(@Valid Select s,BindingResult br,ModelAndView mv, HttpSession session) {
		log.info("-------开始增加活动-------");
		if(br.hasErrors()) {
			mv.addObject("activity", s);
			mv.setViewName("system/paying/activity/activityinfo");
		}else {
			try {
				activityService.save(s);
				mv.setViewName("redirect:list");
			} catch (Exception e) {
				log.error("-------增加活动失败-------");
				e.printStackTrace();
			}
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 打开修改活动页面
	 * 创建时间:2017年10月16日上午11:47:26
	 * 修改备注:
	 */
	@GetMapping("/update")
	public ModelAndView update(Integer id,ModelAndView mv, HttpSession session) {
		log.info("-------打开活动修改页面-------");
		try {
			Select s = activityService.getActivityById(id);
			mv.addObject("activity", s);
			mv.setViewName("system/paying/activity/activityinfo");
		} catch (Exception e) {
			log.error("-------打开活动修改页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 修改活动控制
	 * 创建时间:2017年10月16日上午11:49:26
	 * 修改备注:
	 */
	@PostMapping("/update")
	public ModelAndView update(@Valid Select s,BindingResult br,ModelAndView mv, HttpSession session) {
		log.info("-------开始修改活动-------");
		if(br.hasErrors()) {
			mv.addObject("activity", s);
			mv.setViewName("system/paying/activity/activityinfo");
		}else {
			try {
				activityService.update(s);
				mv.setViewName("redirect:list");
			} catch (Exception e) {
				log.error("-------修改活动失败-------");
				e.printStackTrace();
			}
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 删除单个活动信息
	 * 创建时间:2017年10月16日上午11:58:49
	 * 修改备注:
	 */
	@GetMapping("/del")
	public ModelAndView del(ModelAndView mv,Integer id) {
		log.info("-------开始删除单个活动信息-------");
		try {
			activityService.getActivityById(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------删除单个活动信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 批量删除活动信息
	 * 创建时间:2017年10月16日上午12:02:49
	 * 修改备注:
	 */
	@GetMapping("/dels")
	public ModelAndView dels(ModelAndView mv,String id) {
		log.info("-------开始批量删除活动信息-------");
		try {
			activityService.delActivityByIds(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------批量删除活动信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	

}
