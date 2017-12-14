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
import com.bz.manage.phoneversion.FlowerAndPet;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机版商城鲜花、宠物、农资实体类控制器
 * 创建时间:2017年10月16日下午4:11:07
 * 修改备注:
 */
@Controller
@RequestMapping(value="material/flower")
public class FlowerAndPetController {

	private static final Log log = LogFactory.getLog(FlowerAndPetController.class);
	
//	@Autowired
//	private FlowerAndPetService flowerAndPetService;
	
	/**
	 * 
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午4:11:56
	 * 描述:分页查询鲜宠类实体
	 * @param mv
	 * @param pb
	 * @param flowerAndPet
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,FlowerAndPet flowerAndPet) {
		log.info("分页查询鲜花、宠物商品");
		try {
			//flowerAndPetService..setIsDelete(0);
			//mv.addObject("sharelist", flowerAndPetService.seleteListPage(pb,flowerAndPet));
			FlowerAndPet aducloth = new FlowerAndPet();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/flower/flowerlist");
		}catch (Exception e) {
			log.error("分页查询鲜花宠物出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午4:12:18
	 * 描述:跳转增加鲜花、宠物页面
	 * @param mv
	 * @param flowerAndPet
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,FlowerAndPet flowerAndPet) {
		log.info("跳转增加鲜花、宠物页面");
		try {
			flowerAndPet.setIsDelete(0);
			mv.addObject("flowerAndPet", flowerAndPet);
			mv.setViewName("material/flower/flowerinfo");
		}catch (Exception e) {
			log.error("跳转增加页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午4:12:32
	 * 描述:增加鲜花、宠物实体
	 * @param mv
	 * @param flowerAndPet
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid FlowerAndPet flowerAndPet,BindingResult bd) {
		log.info("增加鲜花、宠物实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("flowerAndPet", flowerAndPet);
				mv.setViewName("material/flower/flowerinfo");
			}else {
				flowerAndPet.setIsDelete(0);
				//flowerAndPetService.save(flowerAndPet);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("跳转鲜花，宠物页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午4:12:40
	 * 描述:跳转修改鲜花商品页面
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id,HttpSession session) {
		log.info("跳转修改鲜花商品页面");
		try {
			//FlowerAndPet flowerAndPet = flowerAndPetService.selectById(id);
			FlowerAndPet ma = new FlowerAndPet();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("flowerAndPet", ma);
			mv.setViewName("material/flower/flowerinfo");
		}catch (Exception e) {
			log.error("跳转修改页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午4:12:49
	 * 描述:修改鲜花、宠物实体
	 * @param mv
	 * @param flowerAndPet
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid FlowerAndPet flowerAndPet,BindingResult bd) {
		log.info("修改鲜花、宠物实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("flowerAndPet", flowerAndPet);
				mv.setViewName("material/flower/flowerinfo");
			}else {
				//flowerAndPetService.update(flowerAndPet);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改鲜花实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午4:12:59
	 * 描述:根据ID删除鲜花实体
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除鲜花实体");
		try {
			//flowerAndPetService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除鲜花实体错误");
			e.printStackTrace();
		}
		return mv;
	}
}
