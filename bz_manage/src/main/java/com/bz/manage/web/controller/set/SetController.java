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

import com.bz.manage.model.test.Set;

/**
 * 
 * 
 * 作者: 胡竞
 * 描述: 设置控制
 * 创建时间:2017年10月11日 上午10:54:00
 * 修改备注:
 */

@Controller
@RequestMapping(value="/system/admin")
public class SetController {

	private Log log=LogFactory.getLog(SetController.class);
	
	/**
	   * 作者:胡竞
	   * 描述: 进入修改设置基本信息页面
	   * 版本: version 1.0.0
	   * 时间: 2017年10月11日上午11:02:16
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@GetMapping(value="/information")
	public ModelAndView information(ModelAndView mv,HttpSession session,Set s) {
		log.info("进入修改设置基本信息页面");
		
		//测试数据
		s.setName("宝众商城");
		s.setTitle("宝众商城");
		s.setDescription("宝众商城是一个整合线下实体店进驻互联网电商的帮扶平台！");
		s.setKeyword("宝众商城");
		s.setCopyright("宝众商城版权所有");
		s.setCopyrightUrl("http://www.baozho.com");
		s.setLogo("");//文件地址
		s.setIcp("宝众商城");
		s.setLocation("重庆市");
		s.setAddress("江北区富力海洋广场2幢108号");
		s.setPostcode("");
		s.setPhone("400-614-0039");
		s.setEmail("3363287476@qq.com");
		s.setIsdelete(0);
		s.setReason("商城维护中，暂时关闭，请稍候访问。");
		s.setSearch("宝众商城,巧克力,洗面奶,连衣裙,外套,奶粉");
		s.setBaiduKey("22bb7221fc279a484895afcc6a0bb33a");
		s.getName();
		
		
		mv.addObject("information",s);
		mv.setViewName("system/sitesSet/informationSet");
		
		return mv;
	}
	
	/**
	   * 作者:胡竞
	   * 描述: 修改设置基本信息
	   * 版本: version 1.0.0
	   * 时间: 2017年10月11日下午2:02:56
	   * @param request
	   * @return
	   * ModelAndView
	 */
	@PostMapping(value="/information")
	public ModelAndView information(ModelAndView mv,@Valid Set s,BindingResult result,HttpSession session) {
		log.info("修改设置基本信息");
		if(result.hasErrors()) {
			log.info("修改信息失败");
			mv.setViewName("system/sitesSet/informationSet");
		}else {
			
			mv.addObject("information",s);
			mv.setViewName("redirect:informationSet");
		}
		return mv;
	}
}
