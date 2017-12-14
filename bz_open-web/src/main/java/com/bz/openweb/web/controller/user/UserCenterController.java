package com.bz.openweb.web.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;
import com.bz.openweb.config.constant.SystemConstant;
import com.bz.openweb.core.service.user.UserCenterService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


/**
* @ClassName: UserScanOrderController 
* @Description: TODO(用户中心首页控制) 
* @author 胡竞
* @date 2017年11月22日 下午5:51:44 
*
 */
@Controller
@RequestMapping(value="/user")
public class UserCenterController {

	private final Logger logger=LoggerFactory.getLogger(UserCenterController.class);
	
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    CacheManager cacheManager;
    @Autowired
    private UserCenterService userCenterService;
    
    
    
    /**
    * @作者 胡竞
    * @Title: registGetCode 
    * @Description: TODO(获取授权code) 
    * @param @param modelAndView
    * @param @return    设定文件 
    * @return ModelAndView    返回类型 
    * @throws
     */
    @GetMapping(value="/centerCode")
	public ModelAndView registGetCode(ModelAndView modelAndView){
		logger.info("跳转微信授权页面");
		String notifyUrl="http://att397200731.eicp.net/user/index";
		modelAndView.setViewName("redirect:"+wxMpService.oauth2buildAuthorizationUrl(notifyUrl, WxConsts.OAUTH2_SCOPE_USER_INFO,"123"));
		return modelAndView;
	}

    /**
	* @作者 胡竞
	* @Title: userCenter 
	* @Description: TODO(进入用户中心) 
	* @param @param mv  ModelAndView
	* @param @param code  微信授权code
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
    @GetMapping(value="/index")
	public ModelAndView userCenter(ModelAndView mv,String code) {
		logger.info("获取到的【code:"+code+"】");
		if(StringUtils.isEmpty(code)) {
			logger.error("获取到的【code:"+code+"】为空,请求失败");
			mv.setViewName("redirect:centerCode");
			return mv;
		}
		Cache cache=cacheManager.getCache("wxCode");
		Element element=cache.get(code);
		WxMpUser user=null;
		if(element!=null) {
			user=(WxMpUser) element.getValue();
		}else {
			try {
				WxMpOAuth2AccessToken token=wxMpService.oauth2getAccessToken(code);
				user=wxMpService.oauth2getUserInfo(token, null);
				 Element element1=new Element(code, user);
				 cache.put(element1);
			} catch (Exception e) {
				logger.error("微信获取令牌accessToken出现错误");
				mv.setViewName("redirect:centerCode");
			}
		}
		BaseResult<UserBaseResponseVo> baseResult=BaseResult.newInstance();
		try {
			baseResult=userCenterService.getUserByWxMpUser(user);
		} catch (Exception e) {
			logger.error("用户查询失败");
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY, baseResult.getMessage());
			mv.setViewName("redirect:usercenter");
		}
		mv.addObject("user",baseResult.getData());
		mv.setViewName("user/usercenter");
		return mv;
	}
    
    
    
	
}
