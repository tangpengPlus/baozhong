package com.bz.open.core.service.sms;

import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.vo.request.sms.SmsMessageRequest;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午4:48:56
 * 描述:短信服务接口
 * 备注:
 */
public interface SmsMessageService {
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日下午4:58:09
	 * 描述:发送短信验证码服务
	 * 备注: 该服务自动生成短信验证码
	 * @param smsMessage{@link SmsMessageRequest} 短信信息封装
	 * @return
	 * @throws ExternalException {@link ExternalException}第三方服务异常封装
	 */
	public boolean sendVerificationMessage(SmsMessageRequest smsMessage)throws ExternalException;
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月17日上午11:51:02
	 * 描述:验证手机验证码是否正确
	 * 备注:
	 * @param telPhone:发送短信的手机号码
	 * @param code:验证码
	 * @return
	 * @throws ExternalException {@link ExternalException}第三方服务异常封装
	 */
	public boolean isTrueVerificationCode(String telPhone,String code)throws ExternalException;
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月17日上午11:52:47
	 * 描述:普通短信发送
	 * 备注:
	 * @param smsMessage {@link SmsMessageRequest} 短信信息封装
	 * @return
	 * @throws ExternalException {@link ExternalException}第三方服务异常封装
	 */
	public boolean sendSms(SmsMessageRequest smsMessage)throws ExternalException;
	
}
