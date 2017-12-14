package com.bz.open.core.service.weixin;

import java.io.InputStream;

import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.vo.request.weixin.WeixinMassMessageRequest;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日上午11:27:54
 * 描述:微信群发消息开放接口
 * 备注:
 */
public interface WeixinMessageService {

	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日上午11:41:32
	 * 描述:发送微信文本消息
	 * 备注:
	 * @param messageService {@link WeixinMassMessageRequest}
	 * @return
	 * @throws ExternalException {@link ExternalException}第三方服务异常封装
	 */
	public boolean sendTextMessage(WeixinMassMessageRequest message)throws ExternalException;
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日下午1:45:29
	 * 描述:发送视频消息
	 * 备注:
	 * @param message:消息封装体 {@link WeixinMassMessageRequest}
	 * @return
	 * @throws ExternalException {@link ExternalException}第三方服务异常封装
	 */
	public boolean sendVideoMessage(WeixinMassMessageRequest message,InputStream inputStream)throws ExternalException;
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日下午2:11:09
	 * 描述:发送微信图片消息
	 * 备注:
	 * @param message:消息封装体 {@link WeixinMassMessageRequest}
	 * @return
	 * @throws ExternalException:{@link ExternalException}第三方服务异常封装
	 */
	public boolean sendImageMessage(WeixinMassMessageRequest message,InputStream inputStream)throws ExternalException;

	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日下午2:13:08
	 * 描述:发送微信语音消息
	 * 备注:
	 * @param message:消息封装体 {@link WeixinMassMessageRequest}
	 * @return
	 * @throws ExternalException:{@link ExternalException}第三方服务异常封装
	 */
	public boolean sendVoiceMessage(WeixinMassMessageRequest message,InputStream inputStream)throws ExternalException;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 发送微信图文消息
	 * 创建时间:2017年11月21日上午11:06:59
	 * @param message
	 * @param inputStream
	 * @return
	 * @throws ExternalException
	 */
	public boolean sendImageTextMessage(WeixinMassMessageRequest message,InputStream inputStream)throws ExternalException;

}
