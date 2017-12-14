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
import com.bz.manage.phoneversion.AdultClothing;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机商城男装，女装，内衣分类
 * 创建时间:2017年10月13日上午10:35:37
 * 修改备注:
 */
@Controller
@RequestMapping(value="/material/adultclothing")
public class AdultClothingController {

	private static final Log log = LogFactory.getLog(AdultClothingController.class);
//	@Autowired
//	private AdultClothingService adultClothingService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日上午10:25:06
	 * 描述:分页显示首页男女装类目信息
	 * @param mv 视图
	 * @param pb 分页
	 * @param adultClothing 服装实体
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,AdultClothing adultClothing) {
		log.info("分页查询男女装类目信息");
		try {
			//adultClothing.setIsDelete(0);
			//mv.addObject("phoidexliset",adultClothingService.selectListPage(pb,adultClothing));
			AdultClothing aducloth = new AdultClothing();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			
			mv.addObject("phoidexliset", aducloth);
			//设置分页
			mv.addObject("pagebean", pb);
			mv.setViewName("material/adultclothing/adultclothinglist");
		}catch (Exception e) {
			log.error("分页查询男女装类目错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日下午3:03:04
	 * 描述:增加男女装跳转页面
	 * @param mv 返回模型视图
	 * @param phoindex 增加的实体
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,AdultClothing adultClothing) {
		log.info("增加手机男女装实体跳转页面");
		try {
			adultClothing.setIsDelete(0);
			mv.addObject("phoindex", new AdultClothing());
			mv.setViewName("material/adultclothing/adultclothinginfo");
		}catch (Exception e) {
			log.error("增加男女装实体出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日下午3:04:59
	 * 描述:增加男女装实体
	 * @param mv 但会的视图模型
	 * @param pindex 增加实体
	 * @param bd 验证实体
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid AdultClothing adultClothing,BindingResult bd) {
		log.info("增加男女装页面素材管理");
		try {
			if(bd.hasErrors()) {
				adultClothing.setIsDelete(0);
				mv.addObject("pindex", adultClothing);
				mv.setViewName("material/adultclothing/adultclothinginfo");
				
			}else {
				//adultClothingService.save(adultClothing));
				
				
				AdultClothing phoindex = new AdultClothing();
				phoindex.setIsDelete(0);
				phoindex.setId(1);
				phoindex.setName(adultClothing.getName());
				phoindex.setPlace(adultClothing.getPlace());
				phoindex.setUrl(adultClothing.getUrl());
				phoindex.setPicture(adultClothing.getPicture());
				log.info("添加的数据："+adultClothing);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("添加男女装实体出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日下午4:58:34
	 * 描述:跳转修改男女装页面
	 * @param id 选择修改的ID
	 * @param mv 返回的视图和模型
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(Integer id,ModelAndView mv) {
		log.info("修改男女装页面");
		try {
			AdultClothing ma = new AdultClothing();
			ma.setIsDelete(0);
			//添加测试数据
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			log.info("ma的信息"+ma);
			mv.addObject("phoindex",ma);
			//mv.addObject("phonelist",adultClothingService.selectById(ma));
			mv.setViewName("material/adultclothing/adultclothinginfo");
		}catch (Exception e) {
			log.error("修改男女装页面跳转错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日上午10:36:43
	 * 描述:开始修改男女装数据
	 * @param mv 返回的模型视图
	 * @param adultClothing 页面传回的修改实体
	 * @param bd 验证
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid AdultClothing adultClothing,BindingResult bd) {
		log.info("开始修改男女装页面");
		try {
			if(bd.hasErrors()) {
				//adultClothing.setIsDelete(0);
				//mv.addObject("adultClothing",adultClothing);
//			    mv.setViewName("material/adultclothing/adultclothinginfo");
			}else {
				//adultClothingService.update(adultClothing);
				//mv.setViewName("redirect:list");
				
				AdultClothing phoindex = new AdultClothing();
				phoindex.setIsDelete(0);
				//测试数据
				phoindex.setId(adultClothing.getId());
				phoindex.setName(adultClothing.getName());
				phoindex.setPlace(adultClothing.getPlace());
				phoindex.setUrl(adultClothing.getUrl());
				phoindex.setPicture(adultClothing.getPicture());
				log.info("添加的测试数据："+phoindex);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改男女装页面出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日上午10:37:00
	 * 描述:根据ID删除男女装类目
	 * @param mv 返回的页面
	 * @param id 需要删除的id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除首页男女装类目");
		try {
			//adultClothingService.delById(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除首页男女装类目错误",e);
			e.printStackTrace();
		}
		return mv;
	}
}
