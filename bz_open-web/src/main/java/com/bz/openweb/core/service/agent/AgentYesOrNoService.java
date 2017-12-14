package com.bz.openweb.core.service.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.open.core.service.agent.AgentApplyService;
import com.bz.open.core.service.weixin.WeixinToolsService;
import com.bz.openweb.core.service.base.BaseService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @author 陈青山
 * @miaoshu 此服务为了判断当前用户是不是此合伙人
 */
@Service
public class AgentYesOrNoService extends BaseService{
	private Logger log=LoggerFactory.getLogger(AgentYesOrNoService.class);
	/*合伙人注册和判断是不是合伙人服务*/
	@Reference(version="1.0.0")
	private AgentApplyService agentApplyService;
	/*微信工具服务*/
	@Reference(version="1.0.0")
	private WeixinToolsService weixinToolsService;
	/**
	 * @author 陈青山
	 * @param type 合伙人类型
	 * @param code 微信code
	 * @miaoshu 判断是不是已经注册
	 * @return
	 */
	public int YesOrNo(String type,String code) {
		log.info("判断是不是已经注册   参数 ：  【类型type】:"+type+" 【微信code】:"+code);
		//需要先得到用户id
		WxMpUser wxUser = getWxUserInfoByCode(code);
		/**
		 * 未完成
		 */
		String userid=null;
		return agentApplyService.ifPass(userid, type);
	}
	@Override
	public WeixinToolsService getWeixinToolsService() {
		return weixinToolsService;
	}
	
	
}
