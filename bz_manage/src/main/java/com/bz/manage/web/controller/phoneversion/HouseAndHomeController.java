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
import com.bz.manage.phoneversion.HouseAndHome;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机版商城家居、家纺类的控制层
 * 创建时间:2017年10月16日下午1:38:33
 * 修改备注:
 */
@Controller
@RequestMapping(value="material/househome")
public class HouseAndHomeController {
	private static final Log log=LogFactory.getLog(HouseAndHomeController.class);
//	@Autowired 
//	private HouseAndHomeService houseAndHomeService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午1:39:10
	 * 描述:分页查询手机、家纺类
	 * @param mv
	 * @param pb
	 * @param houseAndHome
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,HouseAndHome houseAndHome) {
		log.info("分页查询家居产品信息");
		try {
			//houseAndHomeService.setIsDelete(0);
			//mv.addObject("sharelist", houseAndHomeService.seleteListPage(pb,houseAndHome));
			HouseAndHome aducloth = new HouseAndHome();
			
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/househome/househomelist");
		}catch (Exception e) {
			log.error("分页查询页面出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午1:39:32
	 * 描述:增加手机家纺类商品的页面跳转
	 * @param mv
	 * @param houseAndHome
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,HouseAndHome houseAndHome) {
		log.info("跳转增加家居实体页面");
		try {
			houseAndHome.setIsDelete(0);
			mv.addObject("houseAndHome", houseAndHome);
			mv.setViewName("material/househome/househomeinfo");
		}catch (Exception e) {
			log.error("跳转家居增加页面出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午1:40:03
	 * 描述:增加家居家纺的实体类
	 * @param mv
	 * @param houseAndHome
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid HouseAndHome houseAndHome,BindingResult bd) {
		log.info("增加家居实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("houseAndHome", houseAndHome);
				mv.setViewName("material/househome/househomeinfo");
			}else {
				houseAndHome.setIsDelete(0);
				mv.setViewName("redirect:list");
				//houseAndHomeService.save(houseAndHome);
			}
		}catch (Exception e) {
			log.error("增加家居实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午1:40:26
	 * 描述:修改家居家纺商品的页面跳转
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id,HttpSession session) {
		log.info("跳转修改家居页面");
		try {
			//HouseAndHome houseAndHome = houseAndHomeService.selectById(id);
			HouseAndHome ma = new HouseAndHome();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("houseAndHome", ma);
			mv.setViewName("material/househome/househomeinfo");
		}catch (Exception e) {
			log.error("跳转家居修改页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午1:41:04
	 * 描述:根据ID修改家居家纺的实体
	 * @param mv
	 * @param houseAndHome
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid HouseAndHome houseAndHome,BindingResult bd) {
		log.info("修改家居实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("houseAndHome", houseAndHome);
				mv.setViewName("material/househome/househomeinfo");
			}else{
			//	houseAndHomeService.update(houseAndHome);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改家居实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午1:41:30
	 * 描述:根据ID删除家居家纺商品
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除家居实体");
		try {
			//houseAndHomeService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除家居商品错误");
			e.printStackTrace();
		}
		return mv;
	}
}
