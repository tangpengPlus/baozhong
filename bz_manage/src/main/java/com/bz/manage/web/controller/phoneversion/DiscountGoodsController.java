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
import com.bz.manage.phoneversion.DiscountGoods;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:特价商品
 * 创建时间:2017年10月13日下午3:51:36
 * 修改备注:
 */
@Controller
@RequestMapping(value="/material/discountgoods")
public class DiscountGoodsController {

	private static final Log log= LogFactory.getLog(DiscountGoodsController.class);
//	@Autowired
//	private DiscountGoodsService discountGoodsService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午5:15:45
	 * 描述:分页查询特价商品
	 * @param pb 分页
	 * @param discountGoods 优惠商品实体
	 * @return mv 视图模型
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,DiscountGoods discountGoods) {
		log.info("分页查询优惠商品");
		try {
			//discountGoods.setIsDelete(0);
			//mv.addObject("sharelist",hotTypeService.selectListPage(pb,hotType));
			DiscountGoods aducloth = new DiscountGoods();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/discountgoods/discountgoodslist");
		}catch (Exception e) {
			log.error("分页查询优惠商品出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午5:16:13
	 * 描述:增加特价商品的页面跳转
	 * @param discountGoods 优惠商品实体
	 * @return mv 视图模型
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,DiscountGoods discountGoods) {
		log.info("跳转增加优惠商品页面");
		try {
			discountGoods.setIsDelete(0);
			mv.addObject("discountGoods",discountGoods);
			mv.setViewName("material/discountgoods/discountgoodsinfo");
		}catch (Exception e) {
			log.error("跳转优惠商品页面出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午5:16:45
	 * 描述:增加特价商品页面
	 * @param discountGoods 优惠商品实体
	 * @param bd 检验
	 * @return mv 视图模型
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid DiscountGoods discountGoods,BindingResult bd) {
		log.info("增加优惠商品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("discountGoods", discountGoods);
				mv.setViewName("material/discountgoods/discountgoodsinfo");
			}else {
				discountGoods.setIsDelete(0);
				//discountGoodsService.save(discountGoods);
				DiscountGoods aducloth = new DiscountGoods();
				
				aducloth.setIsDelete(0);
				aducloth.setId(1);
				aducloth.setName("测试one");
				aducloth.setPlace("测试one地址");
				aducloth.setUrl("测试one图片存放的地址");
				aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
				log.info("天加数据："+discountGoods);
				
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("增加优惠商品实体错误",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午5:17:13
	 * 描述:修改特价商品页面的跳转
	 * @param id 选择修改的ID
	 * @return mv 视图模型
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id) {
		log.info("修改优惠商品页面");
		try {
			//DiscountGoods discountGoods = discountGoodsService.selectById(id);
			DiscountGoods ma =new DiscountGoods();
			//添加测试数据
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			
			mv.addObject("discountGoods", ma);
			//mv.addObject("discountGoods", discountGoods);
			mv.setViewName("material/discountgoods/discountgoodsinfo");
		}catch (Exception e) {
			log.error("进入修改页面出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午5:17:43
	 * 描述:根据ID修改特价商品实体
	 * @param discountGoods 优惠商品实体
	 * @param bd 检验
	 * @return mv 视图模型
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid DiscountGoods discountGoods,BindingResult bd) {
		log.info("修改优惠商品实体");
		try {
			if(bd.hasErrors()) {
				//mv.addObject("discountGoods",discountGoods);
				mv.setViewName("material/discountgoods/discountgoodsinfo");
			}else {
				//discountGoodsService.update(discountGoods);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改实体页面出错",e);
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日下午5:18:06
	 * 描述:根据ID删除特价商品
	 * @param id 选择删除的ID
	 * @return mv 视图模型
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除优惠商品");
		try {
			//discountGoodsService.delById(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除优惠商品失败",e);
			e.printStackTrace();
		}
		return mv;
	}
}
