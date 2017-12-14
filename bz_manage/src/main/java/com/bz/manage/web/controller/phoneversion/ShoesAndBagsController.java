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
import com.bz.manage.phoneversion.ShoesAndBags;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:
 * 创建时间:2017年10月13日上午10:34:29
 * 修改备注:手机商城鞋，箱包，配件分类
 */
@Controller
@RequestMapping(value="/material/shoesandbags")
public class ShoesAndBagsController {

	private static final Log log = LogFactory.getLog(ShoesAndBagsController.class);
//	@Autowired
//	private ShoesAndBagsService shoesAndBagsService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日上午10:25:06
	 * 描述:分页显示鞋子，箱包，配件信息
	 * @param mv
	 * @param pb
	 * @param shoesAndBags
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,ShoesAndBags shoesAndBags) {
		log.info("分页查询鞋子，箱包，配件信息");
		try {
			//shoesAndBags.setIsDelete(0);
			//mv.addObject("phoidexliset",shoesAndBagsService.selectListPage(pb,shoesAndBags));
			ShoesAndBags aducloth = new ShoesAndBags();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("phoidexliset", aducloth);
			//设置分页
			
			mv.addObject("pagebean", pb);
			mv.setViewName("material/shoesandbags/shoesandbagslist");
		}catch (Exception e) {
			log.error("分页查询鞋子，箱包，配件错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日下午3:03:04
	 * 描述:增加首页显示素材跳转页面
	 * @param mv
	 * @param phoindex
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,ShoesAndBags shoesAndBags) {
		log.info("增加手机首页实体跳转页面");
		try {
			shoesAndBags.setIsDelete(0);
			mv.addObject("phoindex", new ShoesAndBags());
			mv.setViewName("material/shoesandbags/shoesandbagsinfo");
		}catch (Exception e) {
			log.error("增加首页实体出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日下午3:04:59
	 * 描述:增加首页素材实体
	 * @param mv
	 * @param pindex
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid ShoesAndBags shoesAndBags,BindingResult bd) {
		log.info("增加页面素材管理");
		try {
			if(bd.hasErrors()) {
				
				shoesAndBags.setIsDelete(0);
				mv.addObject("pindex", shoesAndBags);
				mv.setViewName("material/shoesandbags/shoesandbagsinfo");
				
			}else {
				//shoesAndBagsService.save(shoesAndBags));
				
				ShoesAndBags phoindex = new ShoesAndBags();
				phoindex.setIsDelete(0);
				phoindex.setId(1);
				phoindex.setName(shoesAndBags.getName());
				phoindex.setPlace(shoesAndBags.getPlace());
				phoindex.setUrl(shoesAndBags.getUrl());
				phoindex.setPicture(shoesAndBags.getPicture());
				log.info("添加的数据："+shoesAndBags);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("添加首页实体出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日下午4:58:34
	 * 描述:跳转修改首页素材页面
	 * @param id
	 * @param mv
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(Integer id,ModelAndView mv,HttpSession session) {
		log.info("修改页面");
		try {
			ShoesAndBags ma = new ShoesAndBags();
			ma.setIsDelete(0);
			//添加测试数据
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			log.info("ma的信息"+ma);
			mv.addObject("phoindex",ma);
			//mv.addObject("phoindex",shoesAndBagsService.selectById(ma));
			mv.setViewName("material/shoesandbags/shoesandbagsinfo");
		}catch (Exception e) {
			log.error("修改页面跳转错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日上午10:38:43
	 * 描述:根据ID修改手机版首页素材
	 * @param mv
	 * @param shoesAndBags
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid ShoesAndBags shoesAndBags,BindingResult bd) {
		log.info("开始修改页面");
		try {
			if(bd.hasErrors()) {
//			    shoesAndBags.setIsDelete(0);
//			    mv.addObject("phoindex", shoesAndBags);
//			    mv.setViewName("material/shoesAndBags/shoesAndBagsinfo");
			}else {
				//shoesAndBagsService.update(shoesAndBags);
				////mv.setViewName("redirect:list");
				
				ShoesAndBags phoindex = new ShoesAndBags();
				phoindex.setIsDelete(0);
				//测试数据
				phoindex.setId(shoesAndBags.getId());
				phoindex.setName(shoesAndBags.getName());
				phoindex.setPlace(shoesAndBags.getPlace());
				phoindex.setUrl(shoesAndBags.getUrl());
				phoindex.setPicture(shoesAndBags.getPicture());
				//shoesAndBagsService.update(shoesAndBags);
				log.info("添加的测试数据："+phoindex);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改页面出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日上午10:39:17
	 * 描述:根据ID删除手机版首页素材
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除首页鞋子，箱包，配件");
		try {
			//shoesAndBagsService.delById(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除首页鞋子，箱包，配件错误");
			e.printStackTrace();
		}
		return mv;
	}
}
