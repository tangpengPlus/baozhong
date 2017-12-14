package com.bz.open.core.service.weixin;
import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.vo.request.weixin.WeixinTemplateMessageRequest;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午2:31:55
 * 描述:微信模板消息发送开放接口
 * 备注:
 */
public interface WeixinTemplateMessageService {

	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日下午2:42:21
	 * 描述:发送微信模板消息
	 * 备注:
	 * @param WeixinTemplateMessage:模板消息的封装 {@link WeixinTemplateMessageRequest}
	 * @return
	 * @throws ExternalException:第三方服务异常信息封装 {@linkExternalException}
	 */
	public boolean sendWeixinTemplateMessage(WeixinTemplateMessageRequest weixinTemplateMessage)throws ExternalException;
}
