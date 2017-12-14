package com.bz.manage.web.controller.phoneversion;

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

import com.bz.manage.model.system.PageBean;
import com.bz.manage.phoneversion.Motherhood;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机商城孕装商品控制层
 * 创建时间:2017年10月13日下午6:24:11
 * 修改备注:
 */
@Controller
@RequestMapping(value="/material/motherhood")
public class MotherhoodController {

	private static final Log log = LogFactory.getLog(MotherhoodController.class);
//	@Autowired
//	private MotherhoodService motherhoodService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午6:24:44
	 * 描述:分页查询孕装商品信息
	 * @param mv
	 * @param pb
	 * @param motherhood
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,Motherhood motherhood) {
		log.info("分页查询孕装信息");
		try {
			//motherhoodControllerService.setIsDelete(0);
			//mv.addObject("sharelist",motherhoodService.seleteListPage(pb,motherhood));
			Motherhood aducloth = new Motherhood();
			
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/motherhood/motherhoodlist");
		}catch (Exception e) {
			log.error("查询孕装信息出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午6:25:03
	 * 描述:增肌孕装商品的跳转页面
	 * @param mv
	 * @param motherhood
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,Motherhood motherhood) {
		log.info("增加孕装页面跳转");
		try {
			motherhood.setIsDelete(0);
			mv.addObject("motherhood",motherhood);
			mv.setViewName("material/motherhood/motherhoodinfo");
		}catch (Exception e) {
			log.error("增加孕装页面跳转出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午6:25:20
	 * 描述:增加孕装商品的实体
	 * @param mv
	 * @param motherhood
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid Motherhood motherhood,BindingResult bd) {
		log.info("增加孕装商品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("motherhood", motherhood);
				mv.setViewName("material/motherhood/motherhoodinfo");
			}else {
				motherhood.setIsDelete(0);
				//motherhoodService.save(motherhood);
				Motherhood aducloth = new Motherhood();
				aducloth.setIsDelete(0);
				aducloth.setId(1);
				aducloth.setName("测试one");
				aducloth.setPlace("测试one地址");
				aducloth.setUrl("测试one图片存放的地址");
				aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("增加孕装商品实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午6:25:51
	 * 描述:修改孕装商品跳转页面
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id,HttpSession session) {
		log.info("进入修改孕装页面");
		try {
			//Motherhood motherhood = motherhoodService.selectById(id);
			Motherhood ma = new Motherhood();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("motherhood", ma);
			//mv.addObject("motherhood",motherhood);
			mv.setViewName("material/motherhood/motherhoodinfo");
		}catch (Exception e) {
			log.error("跳转修改页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午6:26:12
	 * 描述:根据ID修改孕装商品实体
	 * @param mv
	 * @param motherhood
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid Motherhood motherhood,BindingResult bd) {
		log.info("修改孕装实体页面");
		try {
			if(bd.hasErrors()) {
				//mv.addObject("motherhood",motherhood);
				mv.setViewName("material/motherhood/motherhoodinfo");
			}else {
				//motherhoodService.update(motherhood);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改孕装页面出错");
			e.printStackTrace();
		}
		
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午6:26:38
	 * 描述:根据ID删除孕装商品
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除孕装商品");
		try {
			//motherhoodService.delById(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除孕装商品错误");
			e.printStackTrace();
		}
		return mv;
	}
}
