package com.bz.manage.web.controller.paying;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.system.PageBean;
import com.bz.manage.model.test.Select;
import com.bz.manage.service.paying.GoodsService;

/**
 * 
 * 作者: 兰俊
 * 描述: 商品审核控制
 * 版本: version 1.0.0
 * 创建时间:2017年10月16日下午2:54:20
 */
@Controller
@RequestMapping("system/goods")
public class GoodsController {

private Log log = LogFactory.getLog(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取商品列表
	 * 创建时间:2017年10月16日下午2:54:48
	 * 修改备注:
	 */
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb) {
		log.info("-------打开商品页面-------");
		try {
			mv.addObject("goodsList", goodsService.getGoodsAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/goods/goodslist");
		} catch (Exception e) {
			log.error("-------打开商品页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件获取商品列表
	 * 创建时间:2017年10月16日下午2:57:08
	 * 修改备注:
	 */
	@PostMapping("/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Select s) {
		log.info("-------打开商品条件查询页面-------");
		try {
			mv.addObject("goodsList", goodsService.getGoodsAll(s));
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/goods/goodslist");
		} catch (Exception e) {
			log.error("-------打开商品条件查询页面失败-------");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 获取商品待审核列表
	 * 创建时间:2017年10月16日下午3:00:16
	 * 修改备注:
	 */
	@GetMapping("/check")
	public ModelAndView check(ModelAndView mv,PageBean pb) {
		log.info("-------打开商品待审核页面-------");
		try {
			mv.addObject("checkList", goodsService.getGoodsCheckAll());
			mv.addObject("pagebean", pb);
			mv.setViewName("system/paying/goods/goodscheckPendinglist");
		} catch (Exception e) {
			log.error("-------打开商品待审核页面失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 删除单个商品信息
	 * 创建时间:2017年10月16日下午3:03:49
	 * 修改备注:
	 */
	@GetMapping("/del")
	public ModelAndView del(ModelAndView mv,Integer id) {
		log.info("-------开始删除单个商品信息-------");
		try {
			goodsService.delGoodsById(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------删除单个商品信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 批量删除商品信息
	 * 创建时间:2017年10月16日下午3:06:49
	 * 修改备注:
	 */
	@GetMapping("/dels")
	public ModelAndView dels(ModelAndView mv,String id) {
		log.info("-------开始批量删除商品信息-------");
		try {
			goodsService.delGoodsByIds(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("-------批量删除商品信息失败-------");
			e.printStackTrace();
		}
		return mv;
	}
}
