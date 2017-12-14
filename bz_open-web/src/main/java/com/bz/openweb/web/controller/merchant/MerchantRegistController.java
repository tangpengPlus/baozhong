package com.bz.openweb.web.controller.merchant;


import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.openweb.config.constant.SystemConstant;
import com.bz.openweb.core.model.merchant.MerchantRegistRequest;
import com.bz.openweb.core.model.merchant.MerchantRegistResponse;
import com.bz.openweb.core.service.merchant.MerchantRegistService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商家注册控制层
 * 创建时间:2017年11月7日下午1:36:26
 * 修改备注:
 */
@Controller
@RequestMapping(value="/merchant")
public class MerchantRegistController {

	private final Logger logger = LoggerFactory.getLogger(MerchantRegistController.class);
	@Autowired
	private MerchantRegistService merchantRegistService;
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private CacheManager cacheManager;
    
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月8日上午11:12:09
	 * 描述:请求微信跳转获取code
	 * @param modelAndView
	 * @return
	 */
	@GetMapping(value="/registCode")
	public ModelAndView registGetCode(ModelAndView modelAndView){
		logger.info("跳转微信授权页面");
		String notifyUrl="http://att397200731.eicp.net/merchant/regist";
		modelAndView.setViewName("redirect:"+wxMpService.oauth2buildAuthorizationUrl(notifyUrl, WxConsts.OAUTH2_SCOPE_USER_INFO,"123"));
		return modelAndView;
	}
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月8日上午11:15:08
	 * 描述:打开注册页面
	 * @param mv
	 * @param code {@link code} 微信返回的唯一标识
	 * @return
	 */
	@GetMapping(value="/regist")
	public ModelAndView regist(ModelAndView mv,String code,MerchantRegistRequest merchantRegistRequest) {
		logger.info("打开商户注册页面 code:{}",code);
		if(StringUtils.isEmpty(code)) {
			logger.error("获取code错误，请重新进入");
			mv.setViewName("redirect:registCode");
			return mv;
		}
		Cache cache=cacheManager.getCache("wxCode");
		Element element=cache.get(code);
		WxMpUser user =null;
		if(element!=null) {
			user=(WxMpUser) element.getValue();
		}else {
			try {
				WxMpOAuth2AccessToken token=wxMpService.oauth2getAccessToken(code);
				 user = wxMpService.oauth2getUserInfo(token, null);
				 Element element1=new Element(code, user);
				 cache.put(element1);
			} catch (Exception e) {
				mv.setViewName("redirect:registCode");
				return mv;
			}
		}
		merchantRegistRequest.setOpenId(user.getOpenId());
		logger.info(user.getOpenId());
		merchantRegistRequest.setNickname(user.getNickname());
		merchantRegistRequest.setHeadImgUrl(user.getHeadImgUrl());
		mv.addObject("wxUserInfo", merchantRegistRequest);
		//设置页面路径
		mv.setViewName("merchant/regist");
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月8日上午11:59:47
	 * 描述: 商家注册提交
	 * @param merchantRegistRequest {@link merchantRegistRequest}页面填写的商铺信息
	 * @param mv
	 * @return
	 */
	@PostMapping(value="/regist")
	public ModelAndView regist(MerchantRegistRequest merchantRegistRequest,ModelAndView mv) {
		logger.info("商家注册完成，重定向到商家中心");
		BaseResult<MerchantRegistResponse> result=BaseResult.newInstance();
		try {
			result=merchantRegistService.addMerchantShop(merchantRegistRequest);
		}catch (Exception e) {
			logger.debug("添加商铺错误");
			mv.setViewName("merchant/registsuccess");
		}
		if(result.isSucceed()) {
			//重定向到商家首页页面
			mv.setViewName("merchant/registsuccess");
		}else {
			mv.addObject("merchant", merchantRegistRequest);
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY, result.getMessage());
		}
		return mv;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月23日下午2:12:08
	 * 描述:打开修改商铺页面
	 * @param mv
	 * @param id 商铺的ID号
	 * @return
	 */
	@GetMapping(value="/update")
	public ModelAndView update(ModelAndView mv,Integer id) {
		logger.info("打开修改商铺页面，得到的商家Id为：{}",id);
		
		BaseResult<MerchantRegistRequest> result=BaseResult.newInstance();
		try {
			result=merchantRegistService.selectOneMerchantShop(id);
		}catch (Exception e) {
			logger.error("获取商铺信息错误",e);
			mv.setViewName("merchant/update");
			return mv;
		}
			mv.addObject("merchant", result.getData());
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY, result.getMessage());
			mv.setViewName("merchant/regist");
			return mv;
	}
	
	
	
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月23日下午2:36:54
	 * 描述:修改商铺信息提交
	 * @param mv
	 * @param merchantRegistRequest {@link merchantRegistRequest}页面修改的商铺信息
	 * @return
	 */
	@PostMapping(value="/update")
	public ModelAndView update(ModelAndView mv,MerchantRegistRequest merchantRegistRequest) {
		logger.info("商家修改完成，重定向到商家中心,商家修改的信息为：{}",merchantRegistRequest);
		BaseResult<MerchantRegistResponse> result=BaseResult.newInstance();
		try {
			result=merchantRegistService.addMerchantShop(merchantRegistRequest);
		}catch (Exception e) {
			logger.debug("添加商铺错误");
			mv.setViewName("merchant/registsuccess");
		}
		
		if(result.isSucceed()) {
			//重定向到商家首页页面
			mv.setViewName("merchant/registsuccess");
		}else {
			mv.addObject("merchant", merchantRegistRequest);
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY, result.getMessage());
		}
		return mv;
	}
	
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月14日下午9:32:00
	 * 描述: 商家注册发送短信验证码
	 * @param telPhone {@link telPhone} 用户填写的接受短信的电话号码
	 * @return
	 */
	@PostMapping(value="/sendvildCode")
	@ResponseBody
	public String sendvildCode(String telPhone) {
		logger.info("调用服务，向{}发送验证短信",telPhone);
		if(merchantRegistService.sendMessage(telPhone) == true) {
			try {
				merchantRegistService.sendMessage(telPhone);
			} catch (Exception e) {
				logger.error("发送短信失败",e);
				return "false";
			}
			return "success";
		}
		return "false";
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月24日下午4:12:39
	 * 描述:获得区域一级城市
	 * @return
	 */
	@PostMapping(value="/regionOne")
	@ResponseBody
	public JSONArray regionOne(){
		logger.info("获取等级为1的城市列表");
		Map<Integer,String> listLevelOne;
		try {
			listLevelOne = merchantRegistService.getRegin();
		}catch (Exception e) {
			logger.error("获取下级城市失败");
			return null;
		}
		String jsonArray = JSONUtils.toJSONString(listLevelOne);
		JSONArray jsons=JSONArray.parseArray(jsonArray);
		return jsons;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月24日下午5:26:14
	 * 描述:根据ID获取下级城市列表
	 * @param reginId
	 * @return
	 */
	@PostMapping(value="/regionNext")
	@ResponseBody
	public JSONArray regionNext(Integer reginId){
		logger.info("根据上级城市的id：{}获取下级城市的列表",reginId);
		Map<Integer,String> nextReginMap;
		try {
			nextReginMap = merchantRegistService.getSubordinateRegionById(reginId);
		} catch (Exception e) {
			logger.error("获取下级城市失败");
			return null;
		}
		String jsonArray = JSONUtils.toJSONString(nextReginMap);
		JSONArray jsons=JSONArray.parseArray(jsonArray);
		return jsons;
	}
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午4:48:53
	 * 描述:根据ID获取下级商品列表
	 * @param cateId
	 * @return
	 */
	@PostMapping(value="/getCateNext")
	@ResponseBody
	public JSONArray getCateNext(Integer cateId) {
		logger.info("根据上级商品的id：{}获取下级商品的列表",cateId);
		Map<Integer,String> nextcateCate;
		try {
			nextcateCate = merchantRegistService.getNextCateGoods(cateId);
		} catch (Exception e) {
			logger.error("获取下级商品分类失败");
			return null;
		}
		String jsonArray = JSONUtils.toJSONString(nextcateCate);
		JSONArray jsons=JSONArray.parseArray(jsonArray);
		return jsons;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午4:40:14
	 * 描述:获取商品分类的一级分类
	 * @return
	 */
	@PostMapping(value="/cateOneLevel")
	@ResponseBody
	public JSONArray cateOneLevel() {
		logger.info("获取一级商品分类列表");
		Map<Integer,String> listLevelOne;
		try {
			listLevelOne = merchantRegistService.getCateOneLevel();
		}catch (Exception e) {
			logger.error("获取下级城市失败");
			return null;
		}
		String jsonArray = JSONUtils.toJSONString(listLevelOne);
		JSONArray jsons=JSONArray.parseArray(jsonArray);
		return jsons;
	}
}
