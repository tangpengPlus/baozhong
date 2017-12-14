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
import com.bz.manage.phoneversion.Cate;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机版商城美食类的控制类
 * 创建时间:2017年10月16日下午2:57:06
 * 修改备注:
 */
@Controller
@RequestMapping(value="material/cate")
public class CateController {

	private static final Log log = LogFactory.getLog(CateController.class);
	
//	@Autowired
//	private CateService cateService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:57:37
	 * 描述:分页查询美食商品
	 * @param pb 分页
	 * @param cate 美食实体
	 * @return mv 视图和模型
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Cate cate) {
		log.info("分页查询美食");
		try {
			//cateService.setIsDelete(0);
			//mv.addObject("sharelist", cateService.seleteListPage(pb,cate));
			Cate aducloth = new Cate();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/cate/catelist");
		}catch (Exception e) {
			log.error("分页查询美食错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午3:02:17
	 * 描述:增加美食页面跳转
	 * @param cate 美食实体
	 * @return mv 返回的视图模型
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,Cate cate) {
		log.info("跳转增加美食页面");
		try {
			cate.setIsDelete(0);
			mv.addObject("cate", cate);
			mv.setViewName("material/cate/cateinfo");
		}catch (Exception e) {
			log.error("跳转增加美食页面错误",e);
			e.printStackTrace();
		}
		
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:57:57
	 * 描述:跳转美食商品增加实体
	 * @param cate  返回的美食实体	
	 * @param bd 检验
	 * @return mv 视图模型
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid Cate cate,BindingResult bd) {
		log.info("增加美食实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("cate", cate);
				mv.setViewName("material/cate/cateinfo");
			}else {
				cate.setIsDelete(0);
				//cateService.save(cate);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("增加美食实体错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:58:27
	 * 描述:修改美食页面跳转
	 * @param id 修改数据的ID
	 * @return mv 视图模型
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id) {
		log.info("跳转修改美食页面");
		try {
			//Cate cate = cateService.selectById(id);
			Cate ma = new Cate();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("cate", ma);
			mv.setViewName("material/cate/cateinfo");
		}catch (Exception e) {
			log.error("跳转修改页面失败",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:58:43
	 * 描述:跳转美食商品修改实体
	 * @param cate 美食实体
	 * @param bd 检验
	 * @return mv 视图模型
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid Cate cate,BindingResult bd) {
		log.info("修改选择的美食实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("cate", cate);
				mv.setViewName("material/cate/cateinfo");
			}else{
				//cateService.update(cate);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改美食错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午2:59:07
	 * 描述:根据ID删除美食商品实体
	 * @param id 选择删除的ID
	 * @return mv 视图模型
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除美食商品");
		try {
			//cateService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除美食商品错误",e);
			e.printStackTrace();
		}
		return mv;
	}
}
