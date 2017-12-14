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
import com.bz.manage.phoneversion.HotType;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机商城的热门类目控制类
 * 创建时间:2017年10月13日上午10:52:33
 * 修改备注:
 */
@Controller
@RequestMapping(value="/material/hottype")
public class HotTypeController {

	private static final Log log = LogFactory.getLog(HotTypeController.class);
//	@Autowired
//	private HotTypeService hotTypeService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午3:38:40
	 * 描述:分页查询热门商品
	 * @param mv
	 * @param pb
	 * @param hotType
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,HotType hotType) {
		log.info("分页查询热门类目");
		try {
			//htotype.setIsDelte(0);
			//mv.addObject("sharelist",hotTypeService.selectListPage(pb,hotType));
			HotType aducloth =new HotType();
			
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			
			//设置分页
			mv.addObject("pagebean", pb);
			mv.setViewName("material/hottype/hottypelist");
		}catch (Exception e) {
			log.error("分页查询热门类目错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午3:39:19
	 * 描述:增加热门类目页面跳转
	 * @param mv
	 * @param hottype
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,HotType hottype) {
		log.info("增加热门类目跳转页面");
		try {
			hottype.setIsDelete(0);
			mv.addObject("hottype", new HotType());
			mv.setViewName("material/hottype/hottypeinfo");
		}catch (Exception e) {
			log.error("增肌跳转页面出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午3:46:31
	 * 描述:增加热门类目实体
	 * @param mv
	 * @param hottype
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid HotType hottype,BindingResult bd) {
		log.info("增加热门类目实体");
		try {
			if(bd.hasErrors()) {
				
				mv.addObject("hottype", hottype);
				mv.setViewName("material/hottype/hottypeinfo");
			}else {
				hottype.setIsDelete(0);
				//hotTypeService.save(hottype);
				
				HotType aducloth = new HotType();
				aducloth.setIsDelete(0);
				aducloth.setId(1);
				aducloth.setName("测试one");
				aducloth.setPlace("测试one地址");
				aducloth.setUrl("测试one图片存放的地址");
				aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
				log.info("天加数据："+hottype);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
            log.error("增加热门类目出错");
            e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午3:46:54
	 * 描述:修改热门类目跳转页面
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id,HttpSession session) {
		log.info("修改热门类目页面跳转");
		try {
			HotType ma = new HotType();
			ma.setIsDelete(0);
			//添加测试数据
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			log.info("ma的信息"+ma);
			mv.addObject("hottype", ma);
		//	mv.addObject("hottype", hotTypeService.selectById(ma));
			mv.setViewName("material/hottype/hottypeinfo");
		}catch (Exception e) {
			log.error("修改热门类目页面错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午3:47:14
	 * 描述:根据ID修改热门类目实体
	 * @param mv
	 * @param hottype
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid HotType hottype,BindingResult bd) {
		log.info("开始修改热门类目");
		try {
			if(bd.hasErrors()) {
				mv.addObject("hottype",hottype);
				mv.setViewName("material/hottype/hottypeinfo");
			}else {
//				hotTypeService.update(hottype);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改热门类目出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午3:47:45
	 * 描述:根据ID删除热门类目实体
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除热门类目");
		try {
			//hotTypeService.delById(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除类目失败");
			e.printStackTrace();
		}
		return mv;
	}
}
