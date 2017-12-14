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
import com.bz.manage.phoneversion.Material;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:
 * 创建时间:2017年10月11日下午1:55:14
 * 修改备注:手机版的素材管理功能
 */
@Controller
@RequestMapping(value="/material/material")
public class MaterialController {

	private static final Log log = LogFactory.getLog(MaterialController.class);
	
//	@Autowired
//	private MaterialService materialService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月11日上午11:41:22
	 * 描述:查询素材管理信息
	 * @param mv 要查的素材
	 * @param pb 分页查询
	 * @return 素材实体
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Material material) {
		log.info("分页查询素材信息");
		try {
			//请增加
			//material.setIsDelete(0);
			//mv.addObject("materiallist",materialService.selectListPage(pb,material));
			
			//测试数据
			Material ma = new Material();
			ma.setId(1);
			ma.setIsDelete(0);
			ma.setName("测试1");
			ma.setPicture("测试1图片");
			ma.setPlace("测试1广告位置");
			ma.setUrl("测试1图片地址");
			//设置分页
			mv.addObject("materiallist", ma);
			mv.addObject("pagebean", pb);
			mv.setViewName("material/material/materiallist");
		}catch (Exception e) {
			log.error("查询分页信息出错了！");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月11日下午2:08:45
	 * 描述:跳转到增加的页面
	 * @param mv 
	 * @param ma 需要增加的素材
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,Material ma) {
		log.info("增加手机素材页面");
		try {
			ma.setIsDelete(0);
			mv.addObject("material", new Material());
			mv.setViewName("material/material/materialinfo");
		}catch (Exception e) {
			log.error("添加素材页面错误！");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月11日下午3:35:03
	 * 描述:增加手机素材
	 * @param mv 
	 * @param ma 增加的素材实体
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid Material ma,BindingResult bd) {
		log.info("增加素材管理");
		try {
			if(bd.hasErrors()) {
				
				
				ma.setIsDelete(0);
				mv.addObject("ma", ma);
				mv.setViewName("material/material/materialinfo");
			}else {
				
				//materialService.save(ma));
				
				Material material = new Material();
				material.setIsDelete(0);
				//测试数据
				material.setId(1);
				material.setName(ma.getName());
				material.setPlace(ma.getPlace());
				material.setUrl(ma.getUrl());
				material.setPicture(ma.getPicture());
				
				log.info("添加的测试数据："+material);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("添加素材管理错误！");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月11日下午3:51:47
	 * 描述:进入素材修改页面
	 * @param id 选定的素材ID
	 * @param mv
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(Integer id,ModelAndView mv,HttpSession session) {
		log.info("修改页面");
		try {
			Material ma = new Material();
			ma.setIsDelete(0);
			//添加测试数据
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			log.info("ma的信息"+ma);
			mv.addObject("material",ma);
			//mv.addObject("materiallist",materialService.selectById(ma));
			mv.setViewName("material/material/materialinfo");
		}catch (Exception e) {
			log.error("进入素材修改页面错误！");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月11日下午4:14:15
	 * 描述:根据得到的ID修改素材
	 * @param mv
	 * @param ma
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid Material ma,BindingResult bd) {
		log.info("开始修改素材");
		try {
			if(bd.hasErrors()) {
//			    mv.addObject("material", ma);
//			    mv.setViewName("material/material/materialinfo");
			}else {
				//materialService.update(ma);
				//mv.setViewName("redirect:list");
				
				
				Material material = new Material();
				material.setIsDelete(0);
				//测试数据
				material.setId(ma.getId());
				material.setName(ma.getName());
				material.setPlace(ma.getPlace());
				material.setUrl(ma.getUrl());
				material.setPicture(ma.getPicture());
				
				//materialService.update(ma);
				log.info("添加的测试数据："+material);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改数据错误！");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月11日下午4:23:50
	 * 描述:根据id假删除素材
	 * @param mv
	 * @param id 想要删除素材的id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		
		log.info("删除素材");
		try {
			//materialService.delById(id);
			mv.setViewName("redirect:list");
		} catch (Exception e) {
			log.error("删除素材错误",e);
			e.printStackTrace();
		}
		return mv;
	}
}
