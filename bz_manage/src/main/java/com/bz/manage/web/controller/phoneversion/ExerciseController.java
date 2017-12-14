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
import com.bz.manage.phoneversion.Exercise;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机版商城运动/户外/乐器类控制器类
 * 创建时间:2017年10月16日下午5:39:57
 * 修改备注:
 */
@Controller
@RequestMapping(value="material/exercise")
public class ExerciseController {

	private static final Log log = LogFactory.getLog(ExerciseController.class);
//	@Autowired
//	private ExerciseService exerciseService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:41:06
	 * 描述:分页查询户外产品信息
	 * @param exercise 户外实体
	 * @param pb 分页插寻
	 * @return mv 视图模型
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,Exercise exercise,PageBean pb) {
		log.info("分页查询户外产品信息");
		try {
//			exerciseService.setIsDelete(0);
//			mv.addObject("sharelist", exerciseService.seleteListPage(pb,exercise));
			Exercise aducloth = new Exercise();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/exercise/exerciselist");
		}catch (Exception e) {
			log.error("分页查询户外产品错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:41:18
	 * 描述:跳转增加户外产品页面
	 * @param exercise 户外实体
	 * @return mv 视图模型
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,Exercise exercise) {
		log.info("跳转增加户外产品页面");
		try {
			exercise.setIsDelete(0);
			mv.addObject("exercise", exercise);
			mv.setViewName("material/exercise/exerciseinfo");
		}catch (Exception e) {
			log.error("跳转增加页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:41:30
	 * 描述:添加户外运动商品实体
	 * @param exercise 户外实体
	 * @param bd 权限
	 * @return mv 视图模型
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid Exercise exercise,BindingResult bd) {
		log.info("添加户外运动商品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("exercise", exercise);
				mv.setViewName("material/exercise/exerciseinfo");
			}else {
				exercise.setIsDelete(0);
				//exerciseService.save(exercise);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("添加户外商品实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:41:40
	 * 描述:跳转修改户外商品分类
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id,HttpSession session) {
		log.info("跳转修改户外商品分类");
		try {
			//Exercise exercise = exerciseService.selectById(id);
			Exercise ma = new Exercise();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("exercise", ma);
			mv.setViewName("material/exercise/exerciseinfo");
		}catch (Exception e) {
			log.error("添加户外商品页面跳转错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:41:58
	 * 描述:id修改户外运动商品实体
	 * @param mv
	 * @param exercise
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid Exercise exercise,BindingResult bd) {
		log.info("修改户外运动商品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("exercise", exercise);
				mv.setViewName("material/exercise/exerciseinfo");
			}else {
				//exerciseService.update(exercise);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改户外运动实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日下午5:42:10
	 * 描述:id删除户外运动商品
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除户外运动商品");
		try {
			//exerciseService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除户外商品错误");
			e.printStackTrace();
		}
		return mv;
	}
}
