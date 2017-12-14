package com.bz.manage.web.controller.phoneversion;

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
import com.bz.manage.phoneversion.Appliances;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机版商城家电/数码/手机类的控制层
 * 创建时间:2017年10月16日下午1:42:26
 * 修改备注:
 */
@Controller
@RequestMapping(value="material/appliances")
public class AppliancesController {
	private static final Log log = LogFactory.getLog(AppliancesController.class);
//	@Autowired
//	private AppliancesService appliancesService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:27:45
	 * 描述:分页查询手机版商城家电/数码/手机类
	 * @param mv
	 * @param pb 
	 * @param appliances
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Appliances appliances) {
		log.info("分页查询手机数码产品");
		try {
			//appliancesService.setIsDelete(0);
			//mv.addObject("sharelist",appliancesService.seleteListPage(pb,appliances));
			Appliances aducloth = new Appliances();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/appliances/applianceslist");
		}catch (Exception e) {
			log.error("分页查询手机数码产品错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:28:13
	 * 描述:增加手机版商城家电/数码/手机类页面跳转
	 * @param mv 返回的模型视图
	 * @param appliances 传个页面的数据
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,Appliances appliances) {
		log.info("跳转手机数码产品页面");
		try {
			mv.addObject("appliances", appliances);
			mv.setViewName("material/appliances/appliancesinfo");
		}catch (Exception e) {
			log.error("跳转手及数码增加页面错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:28:47
	 * 描述:增加手机版商城家电/数码/手机类页面实体
	 * @param appliances 接受到的页面数据
	 * @param bd 验证
	 * @return mv 返回的模型和视图
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid Appliances appliances,BindingResult bd) {
		log.info("增加手机数码实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("appliances", appliances);
				mv.setViewName("material/appliances/appliancesinfo");
			}else {
				appliances.setIsDelete(0);
				mv.setViewName("redirect:list");
				//appliancesService.save(appliances);
			}
		}catch (Exception e) {
			log.error("增加页面实体错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:29:16
	 * 描述:修改手机版商城家电/数码/手机类跳转页面
	 * @param id 选择修改的ID
	 * @return mv 返回的视图和模型
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id) {
		log.info("跳转修改手机数码商品页面");
		try {
			//Appliances appliances = appliancesService.setlectById(id);
			Appliances ma = new Appliances();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("appliances", ma);
			mv.setViewName("material/appliances/appliancesinfo");
		}catch (Exception e) {
			log.error("跳转修改手机数码商品页面错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:29:32
	 * 描述:根据ID修改手机版商城家电/数码/手机类商品实体
	 * @param appliances 需要修改的实体
	 * @param bd 验证
	 * @return mv 模型和视图
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid Appliances appliances,BindingResult bd) {
		log.info("跳转手机数码商品修改页面");
		try {
			if(bd.hasErrors()) {
				mv.addObject("appliances", appliances);
				mv.setViewName("material/appliances/appliancesinfo");
			}else {
				//appliancesService.update(appliances);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("跳转修改页面错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:30:02
	 * 描述:根据ID删除手机版商城家电/数码/手机类商品实体
	 * @param id 需要修改的实体
	 * @return mv 视图和模型
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除手机数码商品");
		try {
			//appliancesService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除手机数码商品错误",e);
			e.printStackTrace();
		}
		return mv;
	}
}
