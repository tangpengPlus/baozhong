package com.bz.user.core.service.message;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.user.UserMessageMapper;
import com.bz.dao.pojo.user.UserMessage;
import com.bz.framework.constant.exception.BzExceptionEnum.UserExceptionEnum;
import com.bz.framework.error.exception.UserException;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.open.core.service.merchant.MerchantShopRegistService;
import com.bz.open.core.service.message.UserMessageService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;
import com.bz.open.core.vo.response.message.UserMessageResponseVo;

@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.message.UserMessageService.class)
@Transactional
public class UserMessageServiceImpl implements UserMessageService{

	private final Logger logger=LoggerFactory.getLogger(UserMessageServiceImpl.class);
	
	@Autowired
	private UserMessageMapper userMessageMapper;
	@Reference(version="1.0.0")
	private MerchantShopRegistService merchantShopRegistService;
	@Autowired
	private UserBaseService userBaseService;
	
	@Override
	public void addUserMessage(Integer userId, String title, String content) throws UserException {
		logger.info("传入的参数【userId:"+userId+"】,【title:"+title+"】,【content:"+content+"】");
		
		if(StringUtils.isEmpty(title)) {
			logger.error("传入的【title:"+title+"】,为空，添加无法进行");
			throw new UserException(UserExceptionEnum.USER_ADD_MESSAGE_ERROR,"传入的【title:"+title+"】,为空，添加无法进行");
		}
		if(StringUtils.isEmpty(content)) {
			logger.error("传入的【content:"+content+"】,为空，添加无法进行");
			throw new UserException(UserExceptionEnum.USER_ADD_MESSAGE_ERROR,"传入的【content:"+content+"】,为空，添加无法进行");
		}
		UserMessage userMessage=new UserMessage();
		if(userId==null) {
			logger.info("传入【userId:"+userId+"】,【userId】为0存入消息为公有消息");
			userMessage.setId(0);
			userMessage.setIsprivately(1);
		}else {
			userMessage.setUserid(userId);
		}
		userMessage.setTitle(title);
		userMessage.setContent(content);
		userMessage.setCreatetime(new Date());
		userMessageMapper.save(userMessage);
	}

	@Override
	public List<UserMessageResponseVo> selectUserMessage(Integer userId, Integer status) throws UserException {
		logger.info("查询用户信息获取到参数【userId:"+userId+"】,【status:"+status+"】");
		if(userId==null) {
			logger.error("传入的【userId:"+userId+"】为空,查询中止");
			return null;
		}
		if(status==null) {
			logger.error("传入消息状态【status"+status+"】,为空查询中止");
			return null;
		}
		List<UserMessageResponseVo> userMessageVoList=new ArrayList<UserMessageResponseVo>();
		List<UserMessage> userMessageList=new ArrayList<UserMessage>();
		userMessageList=userMessageMapper.selectUserMessage(userId,status);
		for (UserMessage userMessage2 : userMessageList) {

			UserMessageResponseVo userMessageVo=new UserMessageResponseVo();
			//获取用户创建时间
			Date userCreateTimeDate= userBaseService.getUserBaseInfo(userMessage2.getUserid()).getCreatetime();
			//比较用户创建时间和消息时间，如果用户创建的时间大于消息时间，则跳出本次循环
			if(userCreateTimeDate.getTime()>userMessage2.getCreatetime().getTime()) {
				continue;
			}
			//判断用户ID是否为0
			if(userMessage2.getUserid()==0) {
				//设置系统消息的商铺ID
				userMessage2.setShopid(1);
			}
			//创建时间
			userMessageVo.setCreatetime(userMessage2.getCreatetime());
			//userID
			userMessageVo.setUserid(userMessage2.getUserid());
			//店铺ID
			userMessageVo.setId(userMessage2.getId());
			//标题
			userMessageVo.setTitle(userMessage2.getTitle());
			//内容
			userMessageVo.setContent(userMessage2.getContent());
			//通过查询出当前消息对应的店铺
			MerchantShopResponseVo merchantShopResponseVo=merchantShopRegistService.selectMerchantShopById(userMessage2.getShopid());
			//店铺名称
			userMessageVo.setMerchantName(merchantShopResponseVo.getName());
			//店铺图片
			userMessageVo.setMerchantImage(merchantShopResponseVo.getShopfacadeimage());
			//消息类型
			userMessageVo.setIsprivately(userMessage2.getIsprivately());
			
			//添加到集合中
			userMessageVoList.add(userMessageVo);
		}
			return userMessageVoList;
	}

	@Override
	public UserMessageResponseVo selectUserMessageByMessageId(Integer messageId) throws UserException {
		logger.info("传入的消息ID：【messageId:"+messageId+"】");
		if(IntegerUtil.isEmpty(messageId)) {
			logger.error("传入的消息ID为空,【messageId:"+messageId+"】");
			return null;
		}
		//查询出的消息封装到dao层对象
		UserMessage message=userMessageMapper.selectById(messageId);
		//实例化一个响应消息对象
		UserMessageResponseVo messageResponseVo=new UserMessageResponseVo();
		//ID
		messageResponseVo.setId(message.getId());
		//用户ID
		messageResponseVo.setUserid(message.getUserid());
		//标题
		messageResponseVo.setTitle(message.getTitle());
		//内容
		messageResponseVo.setContent(message.getContent());
		//通过查询出当前消息对应的店铺
		MerchantShopResponseVo merchantShopResponseVo=merchantShopRegistService.selectMerchantShopById(message.getShopid());
		//店铺名称
		messageResponseVo.setMerchantName(merchantShopResponseVo.getName());
		//店铺图片
		messageResponseVo.setMerchantImage(merchantShopResponseVo.getShopfacadeimage());
		//时间
		messageResponseVo.setCreatetime(message.getCreatetime());
		
		return messageResponseVo;
	}
}

	
