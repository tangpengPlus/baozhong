package com.bz.openweb.core.service.base;

import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.service.weixin.WeixinToolsService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
/**
 * 
 * 作者: 彭云山
 * 描述:网页端开放服务基础服务
 * 创建时间:2017年11月8日上午11:27:34
 * 修改备注:
 */
public abstract class BaseService {

	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月8日上午11:28:45
	 * 描述: 获取微信工具服务
	 * @return
	 */
	public abstract WeixinToolsService getWeixinToolsService();
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月8日上午11:31:08
	 * 描述: 获取code授权请求地址
	 * @param notifyUrl
	 * @return
	 * @throws ExternalException
	 */
	public String getAuthoUrl(String notifyUrl)throws ExternalException {
	  return getWeixinToolsService().mpOAuth2(notifyUrl);
	}
     /**
 	 * 
 	 * 作者:彭云山
 	 * 创建时间:2017年11月8日上午11:53:54
 	 * 描述:获取微信用户基本信息
 	 * @param code 当前用户的信息
 	 * @return
 	 */
 	public WxMpUser getWxUserInfoByCode(String code) {
 		WxMpUser user=	getWeixinToolsService().getWxMpUser(getWeixinToolsService().getWxMpOAuth2AccessToken(code));
 		return user;
 	}
}
