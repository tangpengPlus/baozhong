package com.bz.open.core.service.push;

import com.bz.framework.error.exception.ExternalException;

/**
* @ClassName: PushService 
* @Description: TODO(极光推送service) 
* @author 胡竞
* @date 2017年10月31日 下午5:47:58 
*
 */
public interface PushService {

	/**
	* @作者 胡竞
	* @Title: sendPushTextMessage 
	* @Description: TODO(发送文本消息给单用户) 
	* @param @param userId 用户ID
	* @param @param title 标题
	* @param @param countent 内容
	* @param @throws ExternalException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void sendPushTextMessage(Integer userId,String title,String countent)throws ExternalException;
	
	/**
	* @作者 胡竞
	* @Title: sendPushUrlMessage 
	* @Description: TODO(发送地址消息给单个用户) 
	* @param @param userId
	* @param @param title
	* @param @param countent
	* @param @param url
	* @param @throws ExternalException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public  void sendPushUrlMessage(Integer userId,String title,String countent,String url)throws ExternalException;
	
	
	/**
	 * 
	* @作者 胡竞
	* @Title: sendPushRegionTextMessage 
	* @Description: TODO(发送区域文本消息) 
	* @param @param regionId
	* @param @param countent
	* @param @throws ExternalException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void sendPushRegionTextMessage(Integer regionId,String title,String countent)throws ExternalException;
	
	/**
	 * 
	* @作者 胡竞
	* @Title: sendPushRegionUrlMessage 
	* @Description: TODO(发送区域网页消息) 
	* @param @param regionId
	* @param @param countent
	* @param @param Url
	* @param @throws ExternalException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void sendPushRegionUrlMessage(Integer regionId,String title,String countent,String url)throws ExternalException;

	/**
	* @作者 胡竞
	* @Title: sendPushAllUser 
	* @Description: TODO(发送推送消息给全部用户) 
	* @param @param title
	* @param @param countent
	* @param @param url
	* @param @throws ExternalException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void sendPushAllUser(String title,String countent,String url) throws ExternalException;

}
