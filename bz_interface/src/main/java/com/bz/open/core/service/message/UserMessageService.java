package com.bz.open.core.service.message;
import java.util.List;

import com.bz.framework.error.exception.UserException;
import com.bz.open.core.vo.response.message.UserMessageResponseVo;

/**
* @ClassName: UserMessageService 
* @Description: TODO(用户消息服务) 
* @author 胡竞
* @date 2017年11月3日 上午11:05:06 
*
 */
public interface UserMessageService{

	/**
	* @作者 胡竞
	* @Title: addUserMessage 
	* @Description: TODO(添加用户消息) 
	* @param @param userId
	* @param @param title
	* @param @param content
	* @param @throws UserException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addUserMessage(Integer userId,String title,String content)throws UserException;
	
	/**
	* @作者 胡竞
	* @Title: selectUserMessage 
	* @Description: TODO(选择查询用户消息) 
	* @param @param userId 用户id
	* @param @param status 状态码:0:查询全部;1:查询私有;2:查询公共信息
	* @param @return
	* @param @throws UserException    设定文件 
	* @return List<UserMessage>    返回类型 
	* @throws
	 */
	public List<UserMessageResponseVo> selectUserMessage(Integer userId,Integer status)throws UserException;
	
	/**
	* @作者 胡竞
	* @Title: selectUserMessageByMessageId 
	* @Description: TODO(通过消息ID查询消息) 
	* @param @return
	* @param @throws UserException    设定文件 
	* @return UserMessageResponseVo    返回类型 
	* @throws
	 */
	public UserMessageResponseVo selectUserMessageByMessageId(Integer messageId)throws UserException;
	
}
