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
import com.bz.manage.phoneversion.BuildingMaterials;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机版商城房产/装修/建材控制类
 * 创建时间:2017年10月16日下午5:11:49
 * 修改备注:
 */
@Controller
@RequestMapping(value="material/buliding")
public class BuildingMaterialsController {

	private static final Log log = LogFactory.getLog(BuildingMaterialsController.class);
	
//	@Autowired
//	private BuildingMaterialsService buildingMaterialsService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:12:30
	 * 描述:分页查询手机版商城房产/装修/建材实体信息
	 * @param pb 数据验证
	 * @param buildingMaterials 查询所获得的实体
	 * @return mv 视图模型
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,BuildingMaterials buildingMaterials) {
		log.info("分页查询建材类商品");
		try {
			//buildingMaterialsService.setIsDelete(0);
			//mv.addObject("sharelist", buildingMaterialsService.seleteListPage(pb,buildingMaterials));
			BuildingMaterials aducloth = new BuildingMaterials();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/buliding/bulidinglist");
		}catch (Exception e) {
			log.error("分页查询建材类商品错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:13:08
	 * 描述:跳转手机版商城房产/装修/建材页面
	 * @param buildingMaterials 增加的建材实体
	 * @return mv 视图和模型
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,BuildingMaterials buildingMaterials) {
		log.info("跳转增加建材页面");
		try {
			buildingMaterials.setIsDelete(0);
			mv.addObject("buildingMaterials", buildingMaterials);
			mv.setViewName("material/buliding/bulidinginfo");
		}catch (Exception e) {
			log.error("跳转增加页面错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:13:24
	 * 描述:增加手机版商城房产/装修/建材实体
	 * @param buildingMaterials 增加的实体
	 * @param bd 验证	
	 * @return mv 视图和模型
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid BuildingMaterials buildingMaterials,BindingResult bd) {
		log.info("增加建材商品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("buildingMaterials", buildingMaterials);
				mv.setViewName("material/buliding/bulidinginfo");
			}else {
				buildingMaterials.setIsDelete(0);
				//buildingMaterialsService.save(buildingMaterials);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("增加建材实体错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:13:40
	 * 描述:跳转手机版商城房产/装修/建材页面
	 * @param id 选择修改的ID
	 * @return mv 视图和模型
	 */
	@GetMapping(value="/update")
	public ModelAndView  update(ModelAndView mv,Integer id) {
		log.info("跳转修改页面");
		try {
			//BuildingMaterials buildingMaterials = buildingMaterialsService.selectById(id);
			BuildingMaterials ma = new BuildingMaterials();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("buildingMaterials", ma);
			mv.setViewName("material/buliding/bulidinginfo");
		}catch (Exception e) {
			log.error("跳转修改页面错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:13:54
	 * 描述:根据ID修改手机版商城房产/装修/建材实体
	 * @param buildingMaterials
	 * @param bd 验证	
	 * @return mv 视图模型
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid BuildingMaterials buildingMaterials,BindingResult bd) {
		log.info("修改建材商品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("buildingMaterials", buildingMaterials);
				mv.setViewName("material/buliding/bulidinginfo");
			}else {
				//buildingMaterialsService.update(buildingMaterials);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改建材页面错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:14:11
	 * 描述:根据Id删除手机版商城房产/装修/建材实体
	 * @param id 选择想要删除的ID
	 * @return mv 视图模型
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除建材商品");
		try {
			//buildingMaterialsService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.info("删除建材商品错误",e);
			e.printStackTrace();
		}
		return mv;
	}
}
