package com.bz.openweb.core.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.open.core.service.message.UserMessageService;
import com.bz.open.core.vo.response.message.UserMessageResponseVo;
/**
* @ClassName: UserCenterMessageService 
* @Description: TODO(用户消息服务) 
* @author 胡竞
* @date 2017年11月27日 上午10:11:03 
*
 */
@Service
public class UserCenterMessageService {

	private final Logger logger=LoggerFactory.getLogger(UserRedpacketService.class);
	
	@Reference(version="1.0.0")
	private UserMessageService userMessageService;
	
	/**
	* @作者 胡竞
	* @Title: getUserAllMessage 
	* @Description: TODO(查询用户所有的消息) 
	* @param @param userId    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public BaseResult<List<UserMessageResponseVo>> getUserAllMessage(Integer userId) {
		
		BaseResult<List<UserMessageResponseVo>> baseResult=BaseResult.newInstance();
		if(IntegerUtil.isEmpty(userId)) {
			logger.error("获取到的userId为空,【userId:"+userId+"】");
			return baseResult.changeStatus(ResultValueEnum.USER_ISNULL_ERROR);
		}
		try {
			baseResult.setData(userMessageService.selectUserMessage(userId, 0));
		} catch (Exception e) {
			logger.error("查询用户消息错误");
			baseResult.changeStatus(ResultValueEnum.USER_SELECT_MESSAGE_ERROR);
		}
		return baseResult;
	}
	
	/**
	* @作者 胡竞
	* @Title: getUserSingleMessage 
	* @Description: TODO(获取用户单个消息) 
	* @param @return    设定文件 
	* @return BaseResult<UserMessageResponseVo>    返回类型 
	* @throws
	 */
	public BaseResult<UserMessageResponseVo> getUserSingleMessage(Integer messageId){
		
		BaseResult<UserMessageResponseVo> baseResult=BaseResult.newInstance();
		try {
			baseResult.setData(userMessageService.selectUserMessageByMessageId(messageId));
		} catch (Exception e) {
			logger.error("查询用户单条消息错误");
			baseResult.changeStatus(ResultValueEnum.USER_SELECT_MESSAGE_ERROR);
		}
		return baseResult;
	}
}
