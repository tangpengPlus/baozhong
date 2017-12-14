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
import com.bz.manage.phoneversion.HelthAndCosmetic;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机商城女装、护理保健品的控制层
 * 创建时间:2017年10月16日上午10:32:04
 * 修改备注:
 */
@Controller
@RequestMapping(value="/material/helth")
public class HelthAndCosmeticController {

	private static final Log log = LogFactory.getLog(HelthAndCosmeticController.class);
//	@Autowired
//	private HelthAndCosmeticService helthAndCosmeticService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日上午11:21:13
	 * 描述:分页查询手机商城女装、护理保健品类实体
	 * @param mv
	 * @param pb
	 * @param helthAndCosmetic
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,HelthAndCosmetic helthAndCosmetic) {
		log.info("分页查询美妆、护理、保健品");
		try {
			//helthAndCosmeticService.setIdDelete(0);
			//mv.addObject("sharelist",helthAndCosmeticService.seleteListPage(pb,helthAndCosmetic));
			HelthAndCosmetic aducloth = new HelthAndCosmetic();
			aducloth.setIsDelete(0);
			aducloth.setId(1);
			aducloth.setName("测试one");
			aducloth.setPlace("测试one地址");
			aducloth.setUrl("测试one图片存放的地址");
			aducloth.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			mv.addObject("sharelist", aducloth);
			
			//设置分页
			mv.addObject("pagebean",pb);
			mv.setViewName("material/helth/helthlist");
		}catch (Exception e) {
			log.error("分页查询护理保健品出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日上午11:21:49
	 * 描述:增加手机商城女装、护理保健品类的跳转页面
	 * @param mv
	 * @param helthAndCosmetic
	 * @return
	 */
	@GetMapping(value="/add")
	public ModelAndView add(ModelAndView mv,HelthAndCosmetic helthAndCosmetic) {
		log.info("增加保健品页面的跳转");
		try {
			helthAndCosmetic.setIsDelete(0);
			mv.addObject("helthAndCosmetic", helthAndCosmetic);
			mv.setViewName("material/helth/helthinfo");
		}catch (Exception e) {
			log.error("跳转页面出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日上午11:22:17
	 * 描述:增加手机商城女装、护理保健品的实体
	 * @param mv
	 * @param helthAndCosmetic
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/add")
	public ModelAndView add(ModelAndView mv,@Valid HelthAndCosmetic helthAndCosmetic,BindingResult bd) {
		log.info("增加保健品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("helthAndCosmetic", helthAndCosmetic);
				mv.setViewName("material/helth/helthinfo");
			}else {
				helthAndCosmetic.setIsDelete(0);
				mv.setViewName("redirect:list");
				//helthAndCosmeticService.save(helthAndCosmetic);
			}
		}catch (Exception e) {
			log.error("增加保健品实体出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日上午11:22:36
	 * 描述:跳转手机商城女装、护理保健品的页面
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id,HttpSession session) {
		log.info("进入修改保健品页面");
		try {
			//HelthAndCosmetic helthAndCosmetic = helthAndCosmeticService.selectById(id);
			HelthAndCosmetic ma = new HelthAndCosmetic();
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			mv.addObject("helthAndCosmetic", ma);
			mv.setViewName("material/helth/helthinfo");
		}catch (Exception e) {
			log.error("进入修改保健品页面出错");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日上午11:22:52
	 * 描述:根据ID修改手机商城女装、护理保健品的实体
	 * @param mv
	 * @param helthAndCosmetic
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid HelthAndCosmetic helthAndCosmetic,BindingResult bd) {
		log.info("修改选择的保健品实体");
		try {
			if(bd.hasErrors()) {
				mv.addObject("helthAndCosmetic", helthAndCosmetic);
				mv.setViewName("material/helth/helthinfo");
			}else {
				//helthAndCosmeticService.update(helthAndCosmetic);
				mv.setViewName("redirect:list");
			}
		}catch (Exception e) {
			log.error("修改保健品实体错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月16日上午11:23:13
	 * 描述:根据ID删除手机商城女装、护理保健品实体
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除保健品实体");
		try {
			//helthAndCosmeticService.delete(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除保健品实体错误");
			e.printStackTrace();
		}
		return mv;
	}
}
