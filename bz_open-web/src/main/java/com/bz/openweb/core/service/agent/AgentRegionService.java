package com.bz.openweb.core.service.agent;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.error.exception.AgentIndexException;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.service.agent.AgentApplyService;
import com.bz.open.core.service.sms.SmsMessageService;
import com.bz.open.core.service.weixin.WeixinToolsService;
import com.bz.open.core.vo.request.agent.AgentRegionRequestVo;
import com.bz.openweb.core.model.agent.AgentRegionRequest;
import com.bz.openweb.core.model.agent.AgentRegionResponse;
import com.bz.openweb.core.service.base.BaseService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;
/**
 * 
 * 
 * @author 陈青山
 * @miaoshu 添加合伙人
 */
@Service
public class AgentRegionService extends BaseService{

	/*微信工具服务*/
	@Reference(version="1.0.0")
	private WeixinToolsService weixinToolsService;
	
	/*合伙人注册服务接口*/
	@Reference(version="1.0.0")
	private  AgentApplyService agentApplyService;
	/*短信接口*/
	@Reference(version="1.0.0")
	private SmsMessageService smsMessageService;
	//以下常量用于对比合伙人类型
	//1为业务合伙人
	private static final String STATE_ONE="1";
	private static final String STATE_TWO="2";
	private static final String STATE_THREE="3";
	private static final String STATE_FOUR="4";
	private static final String STATE_FIVE="5";
	//6为特邀合伙人
	private static final String STATE_SIX="6";
	@Override
	public WeixinToolsService getWeixinToolsService() {
		return weixinToolsService;
	}
	private Logger log=LoggerFactory.getLogger(AgentRegionService.class);
	/**
	 * @作者 陈青山
	 * @描述 合伙人注册服务检查参数是否为空
	 * @描述 合伙人注册服务添加合伙人
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BaseResult<AgentRegionResponse> agent(AgentRegionRequest request,String code){
		log.info("开始判断注册参数		【AgentRegionRequest】  ：" + request);
		//初始化返回结果封装
		BaseResult<AgentRegionResponse> reBaseResult=BaseResult.newInstance();
		if(StringUtils.isEmpty(request.getImPhone())) {
			log.error("合伙人注册参数  【电话  tel】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_TELL_ERROR);
		}
		if(StringUtils.isEmpty(request.getSmsCode())) {
			log.error("合伙人注册参数 【 验证码  smscode】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_SMSCODE_ERROR);
		}
		if(smsMessageService.isTrueVerificationCode(request.getImPhone(),request.getSmsCode())==false) {
			log.error("输入的【短信验证码】错误");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_SMSCODE_ISERROR);
			}
		AgentRegionRequestVo vo=new AgentRegionRequestVo();
		vo.setRegion1(request.getRegion1());
		vo.setRegion2(request.getRegion2());
		vo.setRegion3(request.getRegion3());
		vo.setRegion4(request.getRegion4());
		vo.setAddress(request.getAddress());
		vo.setImPhone(request.getImPhone());
		vo.setLegalCardId(request.getLegalCardId());
		//得到微信用户基本信息
		log.info("获取微信用户基本信息by code    【"+code+"】");
		WxMpUser wxUserInfoByCode = getWxUserInfoByCode(code);
		//设置用户id
		//vo.setUserid(userid);
		vo.setUserName(request.getUserName());
		vo.setSgrade(request.getSgrade());
		try {
			log.info("开始添加合伙人");
			reBaseResult = agentApplyService.apply(vo);
		} catch (AgentIndexException e) {
			log.error("添加合伙人失败");
			e.printStackTrace();
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_INSERT_ERROR);
		}
		return reBaseResult;
	}
}
