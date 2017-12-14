package com.bz.openweb.core.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
* @ClassName: UserCenterService 
* @Description: TODO(用户中心服务) 
* @author 胡竞
* @date 2017年11月23日 上午11:16:05 
*
 */
@Service
public class UserCenterService {

	private final Logger logger=LoggerFactory.getLogger(UserCenterService.class);
	
	@Reference(version="1.0.0")
	private UserBaseService userBaseService;
	
	/**
	* @作者 胡竞
	* @Title: getUserByWxMpUser 
	* @Description: TODO(获取微信对象得到用户对象) 
	* @param @param wxMpUser
	* @param @return    设定文件 
	* @return UserBaseResponseVo    返回类型 
	* @throws
	 */
	public BaseResult<UserBaseResponseVo> getUserByWxMpUser(WxMpUser wxMpUser) {
		logger.info("传入微信对象【WxMpUser】:"+wxMpUser);
		//初始化返回结果封装
		BaseResult<UserBaseResponseVo> baseResult=BaseResult.newInstance();
		if(wxMpUser==null) {
			logger.error("传入的微信对象【WxMpUser】:"+wxMpUser+"为空");
			baseResult.changeStatus(ResultValueEnum.USER_WECHATUSER_ACCREDIT_ERROR);
			return baseResult;
		}
		try {
			UserBaseResponseVo responseVo= userBaseService.getUserByWeiXinUser(wxMpUser);
			baseResult.setData(responseVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResult;
	}
}
