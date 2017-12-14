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
import com.bz.manage.phoneversion.PhoneSetting;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:
 * 创建时间:2017年10月10日下午5:35:11
 * 修改备注:手机版设置相关业务
 */
@Controller
@RequestMapping(value="/material/phoversion")
public class PhoneSettingController {

	private static final Log log =LogFactory.getLog(PhoneSettingController.class);
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月10日下午5:37:43
	 * 描述:进入设置手机商场的描述信息页面
	 * @param mv
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(Integer id,ModelAndView mv,HttpSession session) {
		log.info("设置手机商城描述信息");
		try {
			PhoneSetting phoset = new PhoneSetting();
			//phoset.setIsDelete(0);
			//mv.addObject("phoset", phoneSettingService.selectById(phoset));
			phoset.setId(1);
			phoset.setDescribe("宝众商城是一个整合线下实体店进驻互联网电商的帮扶平台!");
			phoset.setKeyword("宝众商城K");
			phoset.setName("宝众name");
			phoset.setLogo("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			phoset.setLogoname("宝众商城logoname");
			phoset.setIsDelete(0);
			mv.addObject("phoneset", phoset);
			mv.setViewName("material/phoversion/setinfo");
		}catch (Exception e) {
			log.error("设置信息错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日上午10:37:51
	 * 描述:修改手机设置图片业务
	 * @param mv
	 * @param pset
	 * @param bdrt
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid PhoneSetting pset,BindingResult bdrt) {
		log.info("修改手机版信息");
		try{
			if(bdrt.hasErrors()) {
//				pset.setIsDelete(0);
//				mv.addObject("phoneset", pset);
//				mv.setViewName("material/phoversion/setinfo");
			}else {
				//phoneSettingService.update(pset);
				//mv.setViewName("redirect:update");
				
				PhoneSetting phone = new PhoneSetting();
				phone.setId(1);
				phone.setDescribe(pset.getDescribe());
				phone.setKeyword(pset.getKeyword());
				phone.setLogo(pset.getLogo());
				phone.setLogoname(pset.getLogoname());
				phone.setName(pset.getName());
				phone.setIsDelete(0);
				log.info("得到页面的信息"+phone);
				mv.setViewName("redirect:update");
			}
		}catch (Exception e) {
			log.error("修改页面信息错误");
			e.printStackTrace();
		}
		return mv;
	}
}
