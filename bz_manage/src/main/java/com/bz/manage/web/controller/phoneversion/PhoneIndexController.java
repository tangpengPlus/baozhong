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
import com.bz.manage.phoneversion.PhoneIndex;


/**
 * 
 * 
 * 作者: 彭云山
 * 描述:
 * 创建时间:2017年10月12日上午10:22:58
 * 修改备注:手机版首页显示广告图片
 */
@Controller
@RequestMapping(value="/material/phoneindex")
public class PhoneIndexController {
	private static final Log log = LogFactory.getLog(PhoneIndexController.class);
//	@Autowired
//	private PhoneIndexService phoneIndexService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月12日上午10:25:06
	 * 描述:分页显示首页图片信息
	 * @param mv
	 * @param pb
	 * @param phoneIndex
	 * @return
	 */
	@GetMapping(value="/list")
	public ModelAndView list(ModelAndView mv,PageBean pb,PhoneIndex phoneIndex) {
		log.info("分页查询图片信息");
		try {
			//phoneIndex.setIsDelete(0);
			//mv.addObject("phoidexliset",phoneIndexService.selectListPage(pb,phoneIndex));
			PhoneIndex phoidex = new PhoneIndex();
			phoidex.setIsDelete(0);
			phoidex.setId(1);
			phoidex.setName("测试one");
			phoidex.setPlace("测试one地址");
			phoidex.setUrl("测试one图片存放的地址");
			phoidex.setPicture("http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image");
			//设置分页
			mv.addObject("phoidexliset", phoidex);
			mv.addObject("pagebean", pb);
			mv.setViewName("material/phoneindex/phonelist");
		}catch (Exception e) {
			log.error("分页查询图片错误");
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
	public ModelAndView add(ModelAndView mv,PhoneIndex phoindex) {
		log.info("增加手机首页实体跳转页面");
		try {
			phoindex.setIsDelete(0);
			mv.addObject("phoindex", new PhoneIndex());
			mv.setViewName("material/phoneindex/phoneinfo");
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
	public ModelAndView add(ModelAndView mv,@Valid PhoneIndex pindex,BindingResult bd) {
		log.info("增加页面素材管理");
		try {
			if(bd.hasErrors()) {
				
				pindex.setIsDelete(0);
				mv.addObject("pindex", pindex);
				mv.setViewName("material/phoneindex/phoneinfo");
				
			}else {
				//phoneIndexService.save(pindex));
				
				PhoneIndex phoindex = new PhoneIndex();
				phoindex.setIsDelete(0);
				phoindex.setId(1);
				phoindex.setName(pindex.getName());
				phoindex.setPlace(pindex.getPlace());
				phoindex.setUrl(pindex.getUrl());
				phoindex.setPicture(pindex.getPicture());
				log.info("添加的数据："+pindex);
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
			PhoneIndex ma = new PhoneIndex();
			ma.setIsDelete(0);
			//添加测试数据
			ma.setId(1);
			ma.setName("测试数据2");
			ma.setPicture("测试图片2");
			ma.setPlace("测试数据2的广告位置");
			ma.setUrl("测试数据2图片的地址");
			log.info("ma的信息"+ma);
			mv.addObject("pindex",ma);
			//mv.addObject("phonelist",phoneIndexService.selectById(ma));
			mv.setViewName("material/phoneindex/phoneinfo");
		}catch (Exception e) {
			log.error("修改页面跳转错误");
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月13日上午10:40:00
	 * 描述:根据ID修改手机版首页素材
	 * @param mv
	 * @param pindex
	 * @param bd
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,@Valid PhoneIndex pindex,BindingResult bd) {
		log.info("开始修改页面");
		try {
			if(bd.hasErrors()) {
//			    mv.addObject("pindex", pindex);
//			    mv.setViewName("material/phoneIndex/phoneinfo");
			}else {
				//phoneIndexService.update(pindex));
				//mv.setViewName("redirect:list");
				
				
				PhoneIndex phoindex = new PhoneIndex();
				phoindex.setIsDelete(0);
				//测试数据
				phoindex.setId(pindex.getId());
				phoindex.setName(pindex.getName());
				phoindex.setPlace(pindex.getPlace());
				phoindex.setUrl(pindex.getUrl());
				phoindex.setPicture(pindex.getPicture());
				//phoneIndexService.update(pindex);
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
	 * 创建时间:2017年10月13日上午10:40:33
	 * 描述:根据ID删除首页图片
	 * @param mv
	 * @param id
	 * @return
	 */
	@GetMapping(value="/delete")
	public ModelAndView delete(ModelAndView mv,Integer id) {
		log.info("删除首页图片");
		try {
			//phoneIndexService.delById(id);
			mv.setViewName("redirect:list");
		}catch (Exception e) {
			log.error("删除首页图片错误");
			e.printStackTrace();
		}
		return mv;
	}
}
