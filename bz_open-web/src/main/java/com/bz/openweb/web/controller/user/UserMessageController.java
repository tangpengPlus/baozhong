package com.bz.openweb.web.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.vo.response.message.UserMessageResponseVo;
import com.bz.openweb.config.constant.SystemConstant;
import com.bz.openweb.core.service.user.UserCenterMessageService;

/**
* @ClassName: UserMessageController 
* @Description: TODO(用户消息控制) 
* @author 胡竞
* @date 2017年11月24日 下午3:24:43 
*
 */
@Controller
@RequestMapping(value="/user")
public class UserMessageController {

	private final Logger logger=LoggerFactory.getLogger(UserMessageController.class);
	@Autowired
	private UserCenterMessageService userCenterMessageService;
	
	/**
	* @作者 胡竞
	* @Title: userCenterMessage 
	* @Description: TODO(访问用户消息页面) 
	* @param @param mv
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/message")
	public ModelAndView userCenterMessage(ModelAndView mv,Integer id) {
		logger.info("进入用户消息页面");
		BaseResult<List<UserMessageResponseVo>>	baseResult=userCenterMessageService.getUserAllMessage(id);
		if(baseResult.isSucceed()) {
			mv.addObject("message",baseResult.getData());
			mv.setViewName("user/usermessage");
		}else {
			logger.error("查询消息出现错误，跳转失败"+baseResult.getMessage());
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY,baseResult.getMessage());
			mv.setViewName("rediect:index");
		}
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: userSingleMessage 
	* @Description: TODO(访问单个消息详情) 
	* @param @param mv
	* @param @param messageId
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/messageDetails")
	public ModelAndView userSingleMessage(ModelAndView mv,Integer messageId) {
		logger.info("进入用户单条消息页面");
		BaseResult<UserMessageResponseVo> baseResult=userCenterMessageService.getUserSingleMessage(messageId);
		//判断返回是否成功
		if(baseResult.isSucceed()) {
			//成功跳转
			mv.addObject("message",baseResult.getData());
			mv.setViewName("user/message_details");
		}else {
			//失败跳转
			logger.error("跳转消息详情失败,"+baseResult.getMessage());
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY,baseResult.getMessage());
			mv.setViewName("rediect:usermessage");
		}
		return mv;
	}
}
